package com.failtwoconnect.springbootmentalhealthv2.service;

import com.failtwoconnect.springbootmentalhealthv2.dao.AddressRepo;
import com.failtwoconnect.springbootmentalhealthv2.dao.EmergencyContactRepo;
import com.failtwoconnect.springbootmentalhealthv2.dao.UserRepo;
import com.failtwoconnect.springbootmentalhealthv2.dao.UserTypeRepo;
import com.failtwoconnect.springbootmentalhealthv2.exceptions.SaveFailedException;
import com.failtwoconnect.springbootmentalhealthv2.models.User;
import com.failtwoconnect.springbootmentalhealthv2.models.UserType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final AddressRepo addressRepo;
    private final EmergencyContactRepo emergencyContactRepo;
    private final UserTypeRepo userTypeRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo,
                           AddressRepo addressRepo,
                           EmergencyContactRepo emergencyContactRepo,
                           UserTypeRepo userTypeRepo,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.addressRepo = addressRepo;
        this.emergencyContactRepo = emergencyContactRepo;
        this.userTypeRepo = userTypeRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<User> findAllByEnabled(boolean enabled) {
        return userRepo.findAllByEnabled(enabled);
    }

    @Override
    public User findById(int id) {
        Optional<User> user = userRepo.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }


    @Override
    @Transactional
    public void save (User user) throws SaveFailedException {
        if (user == null) {
            throw new IllegalArgumentException("The user object should not be null.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);

        saveIfNotNull(user.getAddress(), addressRepo, "Failed to save user's address.");
        saveIfNotNull(user.getEmergencyContact(), emergencyContactRepo, "Failed to save user's emergency contact information.");
        saveIfNotNull(user.getUserType(), userTypeRepo, "Failed to save user's type information.");
    }

    private <T > void saveIfNotNull (T object, JpaRepository< T, Integer > repo, String errorMessage) throws
    SaveFailedException {
        if (object != null) {
            repo.save(object);
        } else {
            throw new SaveFailedException(errorMessage);
        }
    }




    @Override
    public List<User> findAllByUserType(UserType userType) {
        return userRepo.findAllByUserType(userType);
    }

    @Override
    @Transactional
    public void updateUserByEnabled(boolean enabled, int id){
        userRepo.updateUserByEnabled(enabled,id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String userRole = user.getUserType().getDescription();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userRole));
        return authorities;
    }
}

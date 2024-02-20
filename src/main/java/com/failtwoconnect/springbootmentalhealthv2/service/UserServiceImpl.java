package com.failtwoconnect.springbootmentalhealthv2.service;

import com.failtwoconnect.springbootmentalhealthv2.dao.AddressRepo;
import com.failtwoconnect.springbootmentalhealthv2.dao.EmergencyContactRepo;
import com.failtwoconnect.springbootmentalhealthv2.dao.UserRepo;
import com.failtwoconnect.springbootmentalhealthv2.dao.UserTypeRepo;
import com.failtwoconnect.springbootmentalhealthv2.models.User;
import com.failtwoconnect.springbootmentalhealthv2.models.UserType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final AddressRepo addressRepo;
    private final EmergencyContactRepo emergencyContactRepo;
    private final UserTypeRepo userTypeRepo;
    public UserServiceImpl(UserRepo userRepo,
                           AddressRepo addressRepo,
                           EmergencyContactRepo emergencyContactRepo,
                           UserTypeRepo userTypeRepo) {
        this.userRepo = userRepo;
        this.addressRepo = addressRepo;
        this.emergencyContactRepo = emergencyContactRepo;
        this.userTypeRepo = userTypeRepo;
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
    public void save(User user) {
        if (user != null){
            userRepo.save(user);
            if(user.getAddress() != null){

                addressRepo.save(user.getAddress());
            }else{
                System.out.println("Get address failed");
            }
            if(user.getEmergencyContact() != null){
                emergencyContactRepo.save(user.getEmergencyContact());
            }else{
                System.out.println("Get Emergency Contact Information failed");
            }
            if(user.getUserType() != null) {
                userTypeRepo.save(user.getUserType());
            }else{
                System.out.println("Get User Type failed");
            }
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


}

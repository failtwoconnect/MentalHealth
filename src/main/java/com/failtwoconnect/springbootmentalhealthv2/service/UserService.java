package com.failtwoconnect.springbootmentalhealthv2.service;

import com.failtwoconnect.springbootmentalhealthv2.exceptions.SaveFailedException;
import com.failtwoconnect.springbootmentalhealthv2.models.User;
import com.failtwoconnect.springbootmentalhealthv2.models.UserType;

import java.util.List;

public interface UserService {
    List<User> findAllByEnabled(boolean enabled);
    User findById(int id);
    List<User> findAll();
    void save(User user) throws SaveFailedException;

    List<User> findAllByUserType(UserType userType);
    void updateUserByEnabled(boolean enabled, int id);

}

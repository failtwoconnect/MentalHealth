package com.failtwoconnect.springbootmentalhealthv2.service;

import com.failtwoconnect.springbootmentalhealthv2.dao.UserTypeRepo;
import com.failtwoconnect.springbootmentalhealthv2.models.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService{

    private UserTypeRepo userTypeRepo;

    @Autowired
    public UserTypeServiceImpl(UserTypeRepo userTypeRepo){
        this.userTypeRepo = userTypeRepo;
    }

    @Override
    public List<UserType> findAll() {
        return userTypeRepo.findAll();
    }

    @Override
    public UserType findById(int id) {
        return userTypeRepo.findById(id);
    }
}

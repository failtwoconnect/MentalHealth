package com.failtwoconnect.springbootmentalhealthv2.service;

import com.failtwoconnect.springbootmentalhealthv2.models.UserType;

import java.util.List;

public interface UserTypeService {
    List<UserType> findAll();

    UserType findById(int id);
}

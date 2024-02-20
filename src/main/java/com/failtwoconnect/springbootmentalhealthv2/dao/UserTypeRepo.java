package com.failtwoconnect.springbootmentalhealthv2.dao;

import com.failtwoconnect.springbootmentalhealthv2.models.UserType;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTypeRepo extends JpaRepository<UserType, Integer> {

    List<UserType> findAll();
    UserType findById(int id);
}

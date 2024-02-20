package com.failtwoconnect.springbootmentalhealthv2.dao;

import com.failtwoconnect.springbootmentalhealthv2.models.User;
import com.failtwoconnect.springbootmentalhealthv2.models.UserType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("Select u from User u where u.enabled = :enabled")
    List<User> findAllByEnabled(@Param("enabled") boolean enabled);

    List<User> findAllByUserType(UserType userType);
    @Modifying
    @Transactional
    @Query("update User set enabled = :enabled where user_id = :id")
    void updateUserByEnabled(boolean enabled, int id);


}

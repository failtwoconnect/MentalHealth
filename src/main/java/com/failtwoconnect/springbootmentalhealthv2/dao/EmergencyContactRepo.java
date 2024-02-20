package com.failtwoconnect.springbootmentalhealthv2.dao;

import com.failtwoconnect.springbootmentalhealthv2.models.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyContactRepo extends JpaRepository<EmergencyContact, Integer> {
}

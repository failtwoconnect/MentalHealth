package com.failtwoconnect.springbootmentalhealthv2.dao;

import com.failtwoconnect.springbootmentalhealthv2.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {


}

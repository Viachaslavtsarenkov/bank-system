package com.tsarankou.clientservice.data.repository;

import com.tsarankou.clientservice.data.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
}

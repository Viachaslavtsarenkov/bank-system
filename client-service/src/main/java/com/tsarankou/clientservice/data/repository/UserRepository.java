package com.tsarankou.clientservice.data.repository;

import com.tsarankou.clientservice.data.entity.Email;
import com.tsarankou.clientservice.data.entity.PhoneNumber;
import com.tsarankou.clientservice.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public boolean existsByPhoneNumbersOrEmailList(List<PhoneNumber> phoneNumbers, List<Email> emailList);

}

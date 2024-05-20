package com.tsarankou.clientservice.data.repository;

import com.tsarankou.clientservice.data.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    boolean existsEmailByEmailIn(Collection<String> email);
}

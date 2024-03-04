package com.hostel.admin.repository;

import com.hostel.admin.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
 public interface UserCredentialsRepo extends JpaRepository<UserCredentials,Integer> {
 Optional<UserCredentials> findByEmail(String username);
}

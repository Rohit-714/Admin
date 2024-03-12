package com.hostel.admin.repository;

import com.hostel.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
User findByEmailAndPassword(String email,String password);
User getByEmail(String email);
User getByUid(Long uid);
    Integer deleteByUid(Long uid);
}

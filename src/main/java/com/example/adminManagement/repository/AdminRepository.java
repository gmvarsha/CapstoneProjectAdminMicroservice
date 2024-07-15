package com.example.adminManagement.repository;

import com.example.adminManagement.model.AdminUser;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AdminRepository extends JpaRepository<AdminUser, Long> {
	AdminUser findByEmail(String email);

}



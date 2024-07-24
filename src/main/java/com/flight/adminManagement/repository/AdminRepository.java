package com.flight.adminManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.adminManagement.model.AdminUser;



@Repository
public interface AdminRepository extends JpaRepository<AdminUser, Long> {
	AdminUser findByEmail(String email);

}



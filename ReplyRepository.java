package com.example.adminManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.adminManagement.model.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

}


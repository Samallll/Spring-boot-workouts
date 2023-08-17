package com.example.ls.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ls.model.ApplicationUser;

public interface UserRepository extends JpaRepository<ApplicationUser,Integer>{

}

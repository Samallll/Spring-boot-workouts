package com.example.ls.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ls.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	
	Optional<Role> findByAuthority(String authority);
}

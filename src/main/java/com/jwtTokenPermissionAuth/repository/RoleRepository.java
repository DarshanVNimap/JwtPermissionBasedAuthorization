package com.jwtTokenPermissionAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtTokenPermissionAuth.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}

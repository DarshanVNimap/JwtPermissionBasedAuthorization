package com.jwtTokenPermissionAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtTokenPermissionAuth.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer>{

}

package com.jwtTokenPermissionAuth.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String role;
	
	@ManyToMany(cascade =CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "roles")
	@JsonManagedReference
	private List<User> users;
	
	@OneToMany(cascade = CascadeType.MERGE , mappedBy = "role")
	@JsonManagedReference
	private List<RolePermissionMapper> rolePermissionMapper;

}

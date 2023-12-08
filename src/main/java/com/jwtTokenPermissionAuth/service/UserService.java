package com.jwtTokenPermissionAuth.service;

import java.util.List;

import com.jwtTokenPermissionAuth.dto.UserRequest;

public interface UserService {

	public List<UserRequest> getUsers();

	public UserRequest getUserById(Integer id) throws Exception;

	public UserRequest getUserByName(String name) throws Exception;

	public UserRequest addUserDetail(UserRequest user);

	public UserRequest updateUserDetail(UserRequest user, Integer id) throws Exception;

	public String removeUserDetail(Integer id) throws Exception;

}

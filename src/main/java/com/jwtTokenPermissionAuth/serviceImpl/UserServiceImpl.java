package com.jwtTokenPermissionAuth.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jwtTokenPermissionAuth.dto.UserRequest;
import com.jwtTokenPermissionAuth.entity.Role;
import com.jwtTokenPermissionAuth.entity.User;
import com.jwtTokenPermissionAuth.repository.RoleRepository;
import com.jwtTokenPermissionAuth.repository.UserRepository;
import com.jwtTokenPermissionAuth.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepo;
	
	private final ModelMapper modelMapper;
	
	private final RoleRepository roleRepo;
	
	

	@Override
	public List<UserRequest> getUsers() {
		List<UserRequest> users = userRepo.findAll()
										  .stream().map(
												  user -> modelMapper.map(user, UserRequest.class)
												  ).toList();
		return users;
	}

	@Override
	public UserRequest getUserById(Integer id) throws Exception {
		User user =userRepo.findById(id).orElseThrow(()-> new Exception("User not found with id:"+id));
		return modelMapper.map(user, UserRequest.class);
	}

	@Override
	public UserRequest getUserByName(String name) throws Exception {
		User user = userRepo.findByUsername(name).orElseThrow(()-> new Exception("User not found with username: "+name));
		return modelMapper.map(user, UserRequest.class);
	}

	@Override
	public UserRequest addUserDetail(UserRequest userRequest) {
		
		System.out.println(userRequest);
		User user = modelMapper.map(userRequest, User.class);
		
		System.out.println("USER: " + user);

		List<Role> roles = new ArrayList<>();
		Role role = roleRepo.findById(2).orElseThrow();
		
		roles.add(role);
		user.setRoles(roles);
		User save = userRepo.save(user);
		
		if( save != null) {
			System.out.println(user);
			
			return userRequest;
		}
		return null;
	}

	@Override
	public UserRequest updateUserDetail(UserRequest user, Integer id) throws Exception {
		User getUser = userRepo.findById(id).orElseThrow(() -> new Exception("User not found with user id: "+id));
		User updateUser = modelMapper.map(user, User.class);
		updateUser.setId(id);
		updateUser.setRoles(getUser.getRoles());
		
		if(userRepo.save(updateUser) != null) {
			return user;
		}
		
		return null;
	}

	@Override
	public String removeUserDetail(Integer id) throws Exception {
		User user = userRepo.findById(id).orElseThrow(() -> new Exception("User not found with user id: "+id));
		userRepo.deleteById(id);
		return "User removed with id: "+id;
	}

}

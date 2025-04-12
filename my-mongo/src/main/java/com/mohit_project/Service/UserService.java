package com.mohit_project.Service;

import java.util.List;

import com.mohit_project.paylode.UserDto;



public interface UserService {
	UserDto creatUser(UserDto userDto);
	UserDto updatUser(UserDto userDto,Long userId);
	void deleteUser(Long userId);
	UserDto getUserById(Long userId);
	List<UserDto> getAllUser();
	public Long countUsers();
	public Long validateEmployee(String email, String password);

}

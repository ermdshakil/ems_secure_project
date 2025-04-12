package com.mohit_project.serviceIpml;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.User;
import com.mohit_project.Repositry.UserRepo;
import com.mohit_project.Service.UserService;
import com.mohit_project.exception.ResourceNotFoundException;
import com.mohit_project.paylode.UserDto;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto creatUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=this.modelMapper.map(userDto, User.class);
		
		User createUser=this.userRepo.save(user);
		return this.modelMapper.map(createUser, UserDto.class);
	}

	@Override
	public UserDto updatUser(UserDto userDto, Long userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));
		
		user.setName(userDto.getName());
		
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		User updateUser=this.userRepo.save(user);
		return this.modelMapper.map(updateUser, UserDto.class);
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));
		this.userRepo.delete(user);
		
	}

	@Override
	public UserDto getUserById(Long userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));
		
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<User> users=this.userRepo.findAll();
		List<UserDto> getAllUser=users.stream().map((ui)->this.modelMapper.map(ui, UserDto.class)).collect(Collectors.toList());
		return getAllUser;
	}

	@Override
	public Long countUsers() {
		return userRepo.count();
	}

	/*
	 * @Override public Long validateEmployee(String email, String password) {
	 * Optional<User> employee = userRepo.findByEmailAndPassword(email, password);
	 * return employee.map(User::getUserId).orElse(null); }
	 */
	@Override
	public Long validateEmployee(String email, String password) {
		 User employee = userRepo.findByEmailAndPassword(email, password);
	        //return employee.map(User::getUserId).orElse(null);
		 if(employee.getUserId()!=null) return employee.getUserId();
		 else return null;
	}

}

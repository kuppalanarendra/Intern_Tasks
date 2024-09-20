package com.feign_client.user_service.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feign_client.user_service.client.APIClient;
import com.feign_client.user_service.dto.DepartmentDto;
import com.feign_client.user_service.dto.ResponseDto;
import com.feign_client.user_service.dto.UserDto;
import com.feign_client.user_service.entity.User;
import com.feign_client.user_service.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private APIClient apiClient;

	@Override
	public User saveUser(User user) {

		return userRepo.save(user);
	}

	@Override
	public ResponseDto getUserDatailsById(int id) {
		User user = userRepo.findById(id).get();
		System.out.println(user);
		UserDto userDto = modelMapper.map(user, UserDto.class);
		System.out.println(userDto);
		
	DepartmentDto departmentDto=	apiClient.getDepartmentById(user.getDepartmentId());
	   ResponseDto resposneDto= new ResponseDto();
	   resposneDto.setUserDto(userDto);
	   resposneDto.setDepartmentDto(departmentDto);
		return resposneDto;
	}

}

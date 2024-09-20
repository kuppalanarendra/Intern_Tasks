package com.feign_client.user_service.service;

import com.feign_client.user_service.dto.ResponseDto;
import com.feign_client.user_service.entity.User;

public interface UserService {

	User saveUser(User user);

	ResponseDto getUserDatailsById(int id);

}

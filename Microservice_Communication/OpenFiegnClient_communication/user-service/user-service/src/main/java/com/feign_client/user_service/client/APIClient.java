package com.feign_client.user_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.feign_client.user_service.dto.DepartmentDto;

//declaring a Feign client using the @FeignClient annotation
@FeignClient(value = "department-service", url = "http://localhost:8081")
public interface APIClient {

	@GetMapping("/departments/{id}")
	DepartmentDto getDepartmentById(@PathVariable("id") int id);

}

package com.guglani.test.Production.ready.Features;

import com.guglani.test.Production.ready.Features.client.EmployeeClient;
import com.guglani.test.Production.ready.Features.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class ProductionReadyFeaturesApplicationTests {

	@Autowired
	EmployeeClient employeeClient;



	@Test
	void getAllUsers(){
		List<UserDto> userDtoList= employeeClient.getAllUsers();
		System.out.println(	userDtoList);

	}

	@Test
	void getUserById(){
		UserDto userDto=	employeeClient.getUserById(1L);
		System.out.println(userDto);
	}

	@Test
	void createUser(){
		UserDto userDto= new UserDto(null,"test","test@gmail.com","22",2L);
		UserDto userDto1=	employeeClient.createUser(userDto);
		System.out.println(userDto1);
	}

}

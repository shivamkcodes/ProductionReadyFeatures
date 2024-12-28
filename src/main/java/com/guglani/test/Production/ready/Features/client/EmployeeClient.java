package com.guglani.test.Production.ready.Features.client;

import com.guglani.test.Production.ready.Features.dto.UserDto;

import java.util.List;

public interface EmployeeClient {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto createUser(UserDto userDto);
}

package com.guglani.test.Production.ready.Features.client.impl;

import com.guglani.test.Production.ready.Features.client.EmployeeClient;
import com.guglani.test.Production.ready.Features.dto.UserDto;
import com.guglani.test.Production.ready.Features.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
@Component
public class EmployeeClientImpl implements EmployeeClient {

    @Autowired
    private RestClient restClient;

    Logger logger= LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<UserDto> getAllUsers() {
        try {
          List<UserDto> userDtoList= restClient.get()
                    .uri("user")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
           logger.info("List is {}",userDtoList);
           logger.debug("Debug logger");
          return userDtoList;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }


    }

    @Override
    public UserDto getUserById(Long id) {
        try {
           return restClient.get()
                    .uri("user/{id}",id).
                    retrieve().
                    body(new ParameterizedTypeReference<>() {
                    });
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public UserDto createUser(UserDto userDto) {

        try {
            return restClient.post()
                    .uri("user/add")
                    .body(userDto)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        throw new ResourceNotFoundException("4xx");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}

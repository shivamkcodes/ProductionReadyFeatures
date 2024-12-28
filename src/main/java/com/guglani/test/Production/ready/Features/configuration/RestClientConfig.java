package com.guglani.test.Production.ready.Features.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
@Qualifier("Employee")
public class RestClientConfig {

    @Value("${employee.service.baseUrl}")
    private String baseUrl;

    @Bean
    RestClient getEmployeeRestClient(){
        return RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Accept","application/json")
                .defaultStatusHandler(HttpStatusCode::is5xxServerError,(request, response) -> {
                    throw new RuntimeException("5xx");
                })
                .defaultHeader(CONTENT_TYPE,APPLICATION_JSON_VALUE)

                .build();
    }
}

package com.guglani.test.Production.ready.Features.auth;


import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //get Security Context
        //get Authentication
        //get the principle
        //get the userName
        return Optional.of("Shivam Guglani");
    }


}

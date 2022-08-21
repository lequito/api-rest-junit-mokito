package com.alex.restapijunit.config;

import com.alex.restapijunit.domain.Users;
import com.alex.restapijunit.repositorie.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startdb(){
        Users u1 = new Users(null, "Alex Dias", "lequito@mail.com", "123");
        Users u2 = new Users(null, "Neto Dias", "neto@mail.com", "123");
        Users u3 = new Users(null, "Liz Dias", "liz@mail.com", "123");
        Users u4 = new Users(null, "Heitor Dias", "heitor@mail.com", "123");

        repository.saveAll(List.of(u1,u2,u3,u4));
    }
}

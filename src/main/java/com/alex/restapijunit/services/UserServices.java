package com.alex.restapijunit.services;

import com.alex.restapijunit.domain.Users;
import com.alex.restapijunit.domain.dto.UsersDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserServices {
    Users findById(Integer id);
    List<Users> findAll();
    Users create(UsersDTO obj);
    Users update(UsersDTO obj);
    void delete(Integer id);
}

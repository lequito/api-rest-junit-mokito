package com.alex.restapijunit.services.impl;

import com.alex.restapijunit.domain.Users;
import com.alex.restapijunit.domain.dto.UsersDTO;
import com.alex.restapijunit.repositorie.UserRepository;
import com.alex.restapijunit.services.UserServices;
import com.alex.restapijunit.services.exceptions.DataIntegratyViolatioException;
import com.alex.restapijunit.services.exceptions.ObjectNotFoundException;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Users findById(Integer id) {
        Optional<Users> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Users> findAll(){
        return repository.findAll();
    }

    @Override
    public Users create(UsersDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, Users.class));
    }

    @Override
    public Users update(UsersDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, Users.class));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private void findByEmail(UsersDTO obj){
        Optional<Users> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegratyViolatioException("Email já cadastrado no sistema!");
        }
    }
}

package com.example.feignclient.service;

import com.example.feignclient.model.User;
import com.example.feignclient.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository personRepository;

    public User save(User person){
        return personRepository.save(person);
    }
    public List<User> findAll(){
        return personRepository.findAll();
    }
    public User findById(int id){ return personRepository.findById(id);}
    public void delete(User person){
        personRepository.delete(person);
    }
}

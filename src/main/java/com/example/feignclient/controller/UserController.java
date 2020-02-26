package com.example.feignclient.controller;

import com.example.feignclient.model.User;
import com.example.feignclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/feign")
    public String getfeign(){
        return "SUCCESS FEIGNCLIENT";
    }
    @PostMapping("/add")
    public User createUser(@Valid @RequestBody User person){
        return userService.save(person);
    }

    @GetMapping("/alluser")
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(value = "id") int id) {
        return userService.findById(id);
    }

    @PutMapping("/user/{id}")
    public String update(@PathVariable(value = "id") int id, @Valid @RequestBody User user){
        User user1 = userService.findById(id);
        user1.setName(user.getName());
        User newPerson= userService.save(user1);
        return "başarıyla değiştirildi";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@RequestBody @Valid @PathVariable(value = "id") int id){
        User user=userService.findById(id);
        userService.delete(user);
        return "başarıyla silindi";
    }
}
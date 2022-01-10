package com.example.apiConsultoriosPractica.controller;

import com.example.apiConsultoriosPractica.models.User;
import com.example.apiConsultoriosPractica.serviceImpl.UserServiceImpl;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;


@RestController
//@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/users")
public class UserController extends GenericControllerImpl<User,UserServiceImpl>{

    @Autowired
    UserServiceImpl userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/encrypt")
    public CompletableFuture<ResponseEntity> save(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.save(user).thenApply(ResponseEntity::ok);
    }

}

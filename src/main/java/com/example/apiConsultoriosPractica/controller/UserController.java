package com.example.apiConsultoriosPractica.controller;

import com.example.apiConsultoriosPractica.models.User;
import com.example.apiConsultoriosPractica.modelsDTO.UserDTO;
import com.example.apiConsultoriosPractica.serviceImpl.UserServiceImpl;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
//@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/users")
public class UserController extends GenericControllerImpl<User,UserServiceImpl>{

    @Autowired
    UserServiceImpl userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @GetMapping("/dto/")
    public CompletableFuture<ResponseEntity> getAll(){
            return userService.getAllDTO().thenApply(ResponseEntity::ok);
    }

    @Override
    @PostMapping("/encrypt")
    public CompletableFuture<ResponseEntity> save(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.save(user).thenApply(ResponseEntity::ok);
    }

    //@Override
    @PutMapping("/updateDTO/{id}")
    public CompletableFuture<ResponseEntity> update(@RequestBody UserDTO entityModel,@PathVariable Long id){
        entityModel.setPassword(bCryptPasswordEncoder.encode(entityModel.getPassword()));
        return servicio.updateDTO(entityModel, id).thenApply(ResponseEntity::ok);
    }

    List<String> lista1 = new ArrayList<>();

}

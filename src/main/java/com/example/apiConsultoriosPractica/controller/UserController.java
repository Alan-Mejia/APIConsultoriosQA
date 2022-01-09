package com.example.apiConsultoriosPractica.controller;

import com.example.apiConsultoriosPractica.models.User;
import com.example.apiConsultoriosPractica.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/users")
public class UserController extends GenericControllerImpl<User,UserServiceImpl>{

}

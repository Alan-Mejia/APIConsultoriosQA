package com.example.apiConsultoriosPractica.serviceImpl;

import com.example.apiConsultoriosPractica.models.User;
import com.example.apiConsultoriosPractica.repository.GenericRepository;
import com.example.apiConsultoriosPractica.repository.UserRepository;
import com.example.apiConsultoriosPractica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User,Long> implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(GenericRepository<User, Long> genericRepository) {
        super(genericRepository);
    }
}

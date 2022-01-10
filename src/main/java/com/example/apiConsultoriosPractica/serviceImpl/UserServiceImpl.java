package com.example.apiConsultoriosPractica.serviceImpl;

import com.example.apiConsultoriosPractica.exception.ResourceNotFoundException;
import com.example.apiConsultoriosPractica.models.User;
import com.example.apiConsultoriosPractica.modelsDTO.UserDTO;
import com.example.apiConsultoriosPractica.repository.GenericRepository;
import com.example.apiConsultoriosPractica.repository.UserRepository;
import com.example.apiConsultoriosPractica.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends GenericServiceImpl<User,Long> implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    protected BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(GenericRepository<User, Long> genericRepository) {
        super(genericRepository);
    }

    @Async("asyncExecutor")
    @Transactional
    public CompletableFuture<List<UserDTO>> getAllDTO(){
        List<User> entities = userRepository.findAll();
        List<UserDTO> dtos = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(User user : entities){
            dtos.add(modelMapper.map(user,UserDTO.class));
        }
        return CompletableFuture.completedFuture(dtos);
    }

    @Async("asyncExecutor")
    @Transactional
    public CompletableFuture<User> updateDTO(UserDTO entityModel, Long id) {
        System.out.println( Thread.currentThread().getName());
        User existingUser = genericRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entityModel,existingUser);
        return CompletableFuture.completedFuture(genericRepository.save(existingUser));
    }

}

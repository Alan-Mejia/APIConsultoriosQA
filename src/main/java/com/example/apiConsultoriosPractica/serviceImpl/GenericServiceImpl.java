package com.example.apiConsultoriosPractica.serviceImpl;

import com.example.apiConsultoriosPractica.exception.ResourceNotFoundException;
import com.example.apiConsultoriosPractica.models.SharedInfo;
import com.example.apiConsultoriosPractica.models.User;
import com.example.apiConsultoriosPractica.repository.GenericRepository;
import com.example.apiConsultoriosPractica.service.GenericService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

//@Service
public abstract class GenericServiceImpl<T extends SharedInfo, ID extends Serializable> implements GenericService<T, ID> {
    protected GenericRepository<T,ID> genericRepository;

    public GenericServiceImpl(GenericRepository<T, ID> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    @Transactional
    public T save(T user) {
        return genericRepository.save(user);
    }

    @Override
    @Transactional
    public List<T> getAll() {
        return genericRepository.findAll();
    }

    @Override
    @Transactional
    public T getById(ID id) {
        return genericRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
    }

    @Override
    @Transactional
    public T update(T user, ID id) {
        T existingUser = genericRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
//        existingUser.setName(user.getName());
//        existingUser.setLastName(user.getLastName());
//        existingUser.setSurname(user.getSurname());
//        existingUser.setEmail(user.getEmail());
//        existingUser.setRole(user.getRole());
//        existingUser.setUserName(user.getUserName());
//        existingUser.setPassword(user.getPassword());
//        existingUser.setStatus(user.getStatus());
//        existingUser.setCreationTime(user.getCreationTime());
//        existingUser.setModificationTime(user.getModificationTime());
       // existingUser.setUserCreator(user.getUserCreator());
        return existingUser;
    }

    @Override
    @Transactional
    public void delete(ID id) {
        genericRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
        genericRepository.deleteById(id);
    }

}

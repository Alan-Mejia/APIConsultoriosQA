package com.example.apiConsultoriosPractica.controller;

import com.example.apiConsultoriosPractica.models.SharedInfo;
import com.example.apiConsultoriosPractica.serviceImpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class GenericControllerImpl<T extends SharedInfo, S extends GenericServiceImpl<T,Long>> implements GenericController<T, Long> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected S servicio;

    @PostMapping("")
    public ResponseEntity<T> save(@RequestBody T entityModel){
        return new ResponseEntity<T>(servicio.save(entityModel),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getOne(@RequestBody Long id){
        return new ResponseEntity<T>(servicio.getById(id),HttpStatus.OK);
    }
    @GetMapping("")
    public List<T> getAll(){
        return servicio.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestBody T entityModel, Long id){
        return new ResponseEntity<T>(servicio.update(entityModel,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        servicio.delete(id);
        return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
    }
}


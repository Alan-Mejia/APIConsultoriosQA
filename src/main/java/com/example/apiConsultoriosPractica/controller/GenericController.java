package com.example.apiConsultoriosPractica.controller;

import com.example.apiConsultoriosPractica.models.SharedInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

public interface GenericController <T extends SharedInfo,ID extends Serializable>{
    List<?> getAll();
    ResponseEntity<?> getOne(@PathVariable ID id);
    ResponseEntity<?> save(@RequestBody T entityModel);
    ResponseEntity<?> update(@RequestBody T entityModel,@PathVariable ID id);
    ResponseEntity<String> delete(@PathVariable ID id);


}

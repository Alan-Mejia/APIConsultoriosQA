package com.example.apiConsultoriosPractica.service;

import com.example.apiConsultoriosPractica.models.SharedInfo;

import java.io.Serializable;
import java.util.List;

public interface GenericService <T extends SharedInfo, ID extends Serializable>{

    T save(T entityModel);
    List<T> getAll();
    T getById(ID id);
    T update(T entityModel,ID id);
    void delete(ID id);
}

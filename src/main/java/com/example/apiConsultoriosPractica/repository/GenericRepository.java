package com.example.apiConsultoriosPractica.repository;

import com.example.apiConsultoriosPractica.models.SharedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean//Won't be able to create an instance
public interface GenericRepository<T extends SharedInfo, ID extends Serializable>
        extends JpaRepository<T,ID> {
}

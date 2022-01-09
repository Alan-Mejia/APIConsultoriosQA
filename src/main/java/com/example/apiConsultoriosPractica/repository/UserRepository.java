package com.example.apiConsultoriosPractica.repository;

import com.example.apiConsultoriosPractica.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
    extends GenericRepository<User,Long> {
}

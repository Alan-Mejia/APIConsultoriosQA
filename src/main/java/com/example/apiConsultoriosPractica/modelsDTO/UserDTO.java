package com.example.apiConsultoriosPractica.modelsDTO;

import com.example.apiConsultoriosPractica.models.User;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;

@Data
public class UserDTO{

    @Column(name="Name")
    private String name;

    @Column(name="Username")
    private String username;

    @Column(name="Lastname")
    private String lastName;

    @Column(name="Email")
    private String email;

    @Column(name="Password")
    private String password;


    /*public UserDTO(String name, String username, String lastName, String email, String password) {
        this.name = name;
        this.username = username;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }*/
}

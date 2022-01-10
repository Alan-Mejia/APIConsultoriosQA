package com.example.apiConsultoriosPractica.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends SharedInfo{



    @Column(name="Name")
    private String name;

    @Column(name="Lastname")
    private String lastName;

    @Column(name="Surname")
    private String surname;

    @Column(name="Email")
    private String email;

    @Column(name="Role")
    private Integer role;

    @Column(name="Username")
    private String username;

    @Column(name="Password")
    private String password;



}

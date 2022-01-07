package com.example.apiConsultoriosPractica.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prueba")
public class User extends SharedInfo{
//    @Column(name = "Name")
//    private String name;
//    @Column(name = "LastName")
//    private String lastName;
//    @Column(name = "Surname")
//    private String surname;
//    @Column(name = "Email")
//    private String email;
//    @Column(name = "UserName")
//    private String userName;
//    @Column(name = "Password")
//    private String password;
//
//    /*---------*/
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
//    private Long id;
//
//    @Column(name = "Role")
//    private Integer role;
//
//    @Column(name = "Status")
//    private Integer status;
//
//    @Column(name = "CreationTime")
//    private LocalDateTime creationTime;
//
//    @Column(name = "ModificationTime")
//    private LocalDateTime modificationTime;
//
//    @Column(name = "UserCreator")
//    private Integer userCreator;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "Id")
private Integer id;
    @Column(name = "nombre")
    private String name;
//
}

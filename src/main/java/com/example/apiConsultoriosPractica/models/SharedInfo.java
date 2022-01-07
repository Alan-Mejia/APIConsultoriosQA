package com.example.apiConsultoriosPractica.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class SharedInfo implements Serializable  {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Role")
    private Integer role;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "CreationTime")
    private LocalDateTime creationTime;

    @Column(name = "ModificationTime")
    private LocalDateTime modificationTime;

    @Column(name = "UserCreator")
    private Integer userCreator;
    */

}

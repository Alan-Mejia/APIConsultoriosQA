package com.example.apiConsultoriosPractica.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SharedInfo implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="Status")
    private Integer status;

    @Column(name="Creationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Column(name="Modificationtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationTime;

    @Column(name="Usermodifier")
    private String userModifier;

    @Column(name="Usercreator")
    private String userCreator;
}

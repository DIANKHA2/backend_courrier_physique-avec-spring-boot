package com.webgram.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SERVICE implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;
    private String Nom_service;
    private String Responsable;
    private String Tel_Service;
    private String E_mail_Service;
    private  boolean isDeleted=false;

   // association service user
    @OneToMany(mappedBy = "service") //Un service a  plusieur employee
    private List<Employee> employees;



}

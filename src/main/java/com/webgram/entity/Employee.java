package com.webgram.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_emplid;
    private Long Mat_employe;
    private String Nom_employe;
    private String Fonction_employé;
    private String CIN_employé;
    private String Adress_employé;
    private long Tél__employe;
    private String Date_naissance_employe;
    private String Date_embauche_employe;
    private  boolean isDeleted=false;

    // Association  Service et emplyee
    @ManyToOne( cascade = CascadeType.ALL)// chaque (plusieursà=) emplyee (user)peut avoir un et un seule service
    @JoinColumn(name = "idService" )
    private  SERVICE service;

    // association courier  employee
    @OneToMany(mappedBy = "employee") //Un emplyee (user peut envoyer   plusieur courrier
    private List<COURRIER> courriers;

    @OneToOne( cascade = CascadeType.ALL ) //un employee est  a un sexe
    @JoinColumn( name="id_sexe" )
    private Sexe sexe;


}

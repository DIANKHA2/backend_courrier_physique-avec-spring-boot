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

public class Type_Courrier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type_Courrier;
   // private String type;
    private  boolean isDeleted=false;
    //            assosciation table courrier  et type courrier
   // @OneToMany(mappedBy = "type_courrier") //Une type de courrier peut avoir plusieur courrier
   // private List<COURRIER> courriers;
    @Enumerated(EnumType.STRING)
    private TypeCourrierEnum libelle;

}

package com.webgram.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Nature_Courrier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nature_courrier;
   // private String nature;
    private  boolean isDeleted=false;
    //            assosciation table courrier  et nature courrier
  //  @OneToMany(mappedBy = "nature_courrier") //Une nature de courrier peut avoir plusieur courrier
   // private List<COURRIER> courriers;

    @Enumerated(EnumType.STRING)
    private NatureCourrierEnum libelle;

}

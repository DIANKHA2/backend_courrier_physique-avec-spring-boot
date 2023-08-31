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

public class ETAT implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_etat;
   // private String nature_etat;
    private  boolean isDeleted=false;

    // association etat et courrier
    //@OneToMany(mappedBy ="etat_courrier") //Une etat  peut avoir plusieur etatcourrier
    //private List<COURRIER> courriers;
    @Enumerated(EnumType.STRING)
    private EtatEnum libelle;

}

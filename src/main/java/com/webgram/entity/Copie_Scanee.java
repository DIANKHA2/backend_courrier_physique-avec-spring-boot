package com.webgram.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Copie_Scanee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCopie_Scanee;
    private String copie;
    private String Commentaire_copie;
    private String Date_scan;
    private  boolean isDeleted=false;

    // Association one to one copiescane et courrier comme le premier on a 1.1 alors que le deuxiéme 0.1 donc cette requette ci dessous se met dans la colone qui a le 1.1

    @OneToOne( cascade = CascadeType.ALL ) // on doit scane un courier
    @JoinColumn( name="idcourrier" )
    private COURRIER courrier;



}

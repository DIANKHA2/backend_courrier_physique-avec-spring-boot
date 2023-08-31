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
public class Correspondant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCorrespondnant;
    private Long Mat_Correp ;
    private String Nom_Correp;
    private String Fonction_Correp;
    private String Adress_corresp;
    private Long Tél_corresp;
    private String E_mail_corrsp;
    private String fax_corrsp;
    private  boolean isDeleted=false;
    //@OneToMany(mappedBy = "correspondant") //Un correspondant peut envoyer plusieur Courrier
    //private List<COURRIER> courriers;


    //Table T_coresspondant _courriers_Associations pour la relation plusieur a plusieur
    @ManyToMany(cascade = CascadeType.ALL) //un coresspondant peut avoir plusieur courrier chaque courrier peut avoir plusieur correspondant
    @JoinTable( name = "T_corrrespondant_courriers_Associations",
            joinColumns = @JoinColumn( name = "idCorrespondnant" ),
            inverseJoinColumns = @JoinColumn( name = "idcourrier" ) )
    private List<COURRIER> couri = new ArrayList<>();


}

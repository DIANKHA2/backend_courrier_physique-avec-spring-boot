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
public class COURRIER implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcourrier;
    private Long  ref ;
    private String date_arrivée;
    private String détails;
    private Long Objet;
    private  boolean isDeleted=false;

    //            assosciation table courrier et employee
    @ManyToOne(cascade = CascadeType.ALL) // chaque (plusieursà=) courrier  peut appartenir a  un et un seule user employye
    @JoinColumn(name = "user_emplid")
    private  Employee employee;


    //            assosciation table courrier  et type courrier
    @ManyToOne(cascade = CascadeType.ALL) // chaque (plusieursà=) courrier  peut appartenir a  un et un seule type_couriier
    @JoinColumn(name = "id_type_Courrier")
    private  Type_Courrier type_courrier;


    //            assosciation table courrier Nature  courrier

    @ManyToOne(cascade = CascadeType.ALL) // chaque (plusieursà=) courrier  peut appartenir a  un et un seule nature_couriier
    @JoinColumn(name = "id_nature_courrier")
    private  Nature_Courrier nature_courrier;


    //            assosciation table courrier et etat

    @ManyToOne(cascade = CascadeType.ALL) // chaque (plusieursà=) courrier  peut appartenir a  un et un seule nature_couriier
    @JoinColumn(name = "id_etat")
    private  ETAT etat_courrier;

    //            assosciation table courrier et forme

    @ManyToOne(cascade = CascadeType.ALL) // chaque (plusieursà=) courrier  peut appartenir a  un et un seule nature_couriier
    @JoinColumn(name = "forme_id")
    private  Forme forme_courrier;





    //      Associable des tables plusieurs a plusieurs correspondant et courrier
    // creation automatique de la Table T_corrrespondant_courriers_Associations pour la relation plusieur a plusieur
    @ManyToMany(cascade = CascadeType.ALL) //un coresspondant peut avoir plusieur courrier chaque courrier peut avoir plusieur correspondant
    @JoinTable( name = "T_corrrespondant_courriers_Associations",
            joinColumns = @JoinColumn( name = "idcourrier" ),
            inverseJoinColumns = @JoinColumn( name = "idCorrespondnant" ) )
    private List<Correspondant> corrspd = new ArrayList<>();


}

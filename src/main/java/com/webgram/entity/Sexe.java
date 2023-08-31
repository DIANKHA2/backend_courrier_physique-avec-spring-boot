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
public class Sexe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sexe;
    private String genre;
    private  boolean isDeleted=false;

   // @OneToOne( cascade = CascadeType.ALL ) //un sexe est attribue a un employee
  //  @JoinColumn( name="user_emplid" )
   // private Employee employee;
  // @Enumerated(EnumType.STRING)
   //private SexeEnum libelle;
}

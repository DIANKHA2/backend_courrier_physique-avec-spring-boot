package com.webgram.dao;

import com.webgram.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SexeRepository extends JpaRepository<Sexe,Long> {
    @Query("select sex from Sexe sex where sex.isDeleted=false")
    List<Sexe> getAllSexe();
    //Sexe findByLibelle(SexeEnum libelle);
}

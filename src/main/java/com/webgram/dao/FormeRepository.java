package com.webgram.dao;

import com.webgram.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FormeRepository extends JpaRepository<Forme,Long> {

    @Query("select e from ETAT e where e.isDeleted=false")
    List<Forme> getAllForme();
    Forme findByLibelle(FormeEnum libelle);
}

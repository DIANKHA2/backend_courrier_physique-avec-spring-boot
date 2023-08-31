package com.webgram.dao;

import com.webgram.entity.NatureCourrierEnum;
import com.webgram.entity.Nature_Courrier;
import com.webgram.entity.Role;
import com.webgram.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Nature_CourrierRepository extends JpaRepository<Nature_Courrier,Long> {
    @Query("select NatureCourrier from Nature_Courrier NatureCourrier where NatureCourrier.isDeleted=false")
    List<Nature_Courrier> getAllNature_Courrier();

    Nature_Courrier findByLibelle(NatureCourrierEnum libelle);
}

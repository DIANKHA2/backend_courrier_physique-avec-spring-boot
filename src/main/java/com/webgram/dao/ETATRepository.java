package com.webgram.dao;
import com.webgram.entity.ETAT;
import com.webgram.entity.EtatEnum;
import com.webgram.entity.Role;
import com.webgram.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ETATRepository extends JpaRepository<ETAT,Long> {
    @Query("select e from ETAT e where e.isDeleted=false")
    List<ETAT> getAllETAT();
    ETAT findByLibelle(EtatEnum libelle);
}

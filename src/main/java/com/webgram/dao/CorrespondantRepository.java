package com.webgram.dao;

import com.webgram.entity.Copie_Scanee;
import com.webgram.entity.Correspondant;
import com.webgram.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CorrespondantRepository extends JpaRepository<Correspondant,Long> {
    @Query("select cor from Correspondant cor where cor.isDeleted=false")
    List<Correspondant> getAllCorrespondant();
}

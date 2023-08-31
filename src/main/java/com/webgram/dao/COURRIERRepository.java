package com.webgram.dao;

import com.webgram.entity.COURRIER;
import com.webgram.entity.Copie_Scanee;
import com.webgram.entity.Correspondant;
import com.webgram.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface COURRIERRepository extends JpaRepository<COURRIER,Long> {
    @Query("select cour from COURRIER cour where cour.isDeleted=false")
    List<COURRIER> getAllCOURRIER();



}

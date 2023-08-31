package com.webgram.dao;

import com.webgram.entity.Copie_Scanee;
import com.webgram.entity.Nature_Courrier;
import com.webgram.entity.Type_Courrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Copie_ScaneeReporisitory extends JpaRepository<Copie_Scanee,Long> {
    @Query("select copieScan from Copie_Scanee copieScan where copieScan.isDeleted=false")
    List<Copie_Scanee> getAllCopie_Scanee();
}

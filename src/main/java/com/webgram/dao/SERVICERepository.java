package com.webgram.dao;

import com.webgram.entity.SERVICE;
import com.webgram.entity.Type_Courrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SERVICERepository extends JpaRepository<SERVICE,Long> {
    @Query("select ser from SERVICE ser where ser.isDeleted=false")
    List<SERVICE> getAllSERVICE();

}


package com.webgram.dao;

import com.webgram.entity.Role;
import com.webgram.entity.RoleEnum;
import com.webgram.entity.TypeCourrierEnum;
import com.webgram.entity.Type_Courrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Type_CourrierRepository extends JpaRepository<Type_Courrier,Long> {
    @Query("select typecourrier from Type_Courrier typecourrier where typecourrier.isDeleted=false")
    List<Type_Courrier> getAllType_Courrier();
    Type_Courrier findByLibelle(TypeCourrierEnum libelle);
}

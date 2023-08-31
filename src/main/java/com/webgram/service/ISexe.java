package com.webgram.service;

import com.webgram.entity.Sexe;
import com.webgram.entity.Type_Courrier;

import java.util.List;

public interface ISexe {
    Sexe addSexe(Sexe sexe);
    List<Sexe> getAllSexe();
    Sexe updateSexe(Long id, Sexe sexe);
    void  deletedSexe(Long id);
    Sexe getOneSexe(Long id);
}

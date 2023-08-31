package com.webgram.service;

import com.webgram.entity.Correspondant;
import com.webgram.entity.Type_Courrier;

import java.util.List;

public interface ICorrespondant {
    Correspondant addCorrespondant(Correspondant correspondant);
    List<Correspondant> getAllCorrespondant();
    Correspondant updateCorrespondant(Long id, Correspondant correspondant);
    void  deletedCorrespondant(Long id);
    Correspondant getOneCorrespondant(Long id);
}

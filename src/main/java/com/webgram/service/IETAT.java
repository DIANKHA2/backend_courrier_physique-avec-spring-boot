package com.webgram.service;

import com.webgram.entity.ETAT;
import com.webgram.entity.Type_Courrier;

import java.util.List;

public interface IETAT {
    ETAT addETAT(ETAT etat);
    List<ETAT> getAllETAT();
    ETAT updateETAT(Long id, ETAT etat);
    void  deletedETAT(Long id);
    ETAT getOneETAT(Long id);
}

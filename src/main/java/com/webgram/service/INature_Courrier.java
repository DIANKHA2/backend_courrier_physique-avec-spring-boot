package com.webgram.service;

import com.webgram.entity.Nature_Courrier;

import java.util.List;

public interface INature_Courrier {
    Nature_Courrier addNature_Courrier(Nature_Courrier nature_courrier);
    List<Nature_Courrier> getAllNature_Courrier();
    Nature_Courrier updateNature_Courrier(Long id, Nature_Courrier nature_courrier);
    void  deletedNature_Courrier(Long id);
    Nature_Courrier getOneNature_Courrier(Long id);
}

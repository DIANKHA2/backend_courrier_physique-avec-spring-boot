package com.webgram.service;

import com.webgram.entity.Copie_Scanee;
import com.webgram.entity.Type_Courrier;

import java.util.List;

public interface ICopie_Scanee {
    Copie_Scanee addCopie_Scanee(Copie_Scanee copie_scanee);
    List<Copie_Scanee> getAllCopie_Scanee();
    Copie_Scanee updateCopie_Scanee(Long id, Copie_Scanee copie_scanee);
    void  deletedCopie_Scanee(Long id);
    Copie_Scanee getOneCopie_Scanee(Long id);
}

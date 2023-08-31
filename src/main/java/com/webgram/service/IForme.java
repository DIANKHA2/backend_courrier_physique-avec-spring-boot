package com.webgram.service;

import com.webgram.entity.ETAT;
import com.webgram.entity.Forme;

import java.util.List;

public interface IForme {
   Forme addForme(Forme forme);
    List<Forme> getAllForme();
    Forme updateForme(Long id, Forme forme);
    void  deletedForme(Long id);
    Forme getOneForme(Long id);
}

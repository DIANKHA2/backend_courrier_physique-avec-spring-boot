package com.webgram.service;

import com.webgram.entity.COURRIER;
import com.webgram.entity.Type_Courrier;

import java.util.List;

public interface ICOURRIER {
    COURRIER addCOURRIER(COURRIER courrier);
    List<COURRIER> getAllCOURRIER();
    COURRIER updateCOURRIER(Long id, COURRIER courrier);
    void  deletedCOURRIER(Long id);
    COURRIER getOneCOURRIER(Long id);
}

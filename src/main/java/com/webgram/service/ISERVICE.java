package com.webgram.service;

import com.webgram.entity.SERVICE;
import com.webgram.entity.Type_Courrier;

import java.util.List;

public interface ISERVICE {
    SERVICE addSERVICE(SERVICE service);
    List<SERVICE> getAllSERVICE();
    SERVICE updateSERVICE(Long id, SERVICE service);
    void  deletedSERVICE(Long id);
    SERVICE getOneSERVICE(Long id);
}

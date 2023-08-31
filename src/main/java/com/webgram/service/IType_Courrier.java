package com.webgram.service;

import com.webgram.entity.Nature_Courrier;
import com.webgram.entity.Type_Courrier;

import java.util.List;

public interface IType_Courrier {
    Type_Courrier addType_Courrier(Type_Courrier type_courrier);
    List<Type_Courrier> getAllType_Courrier();
    Type_Courrier updateType_Courrier(Long id, Type_Courrier type_courrier);
    void  deletedType_Courrier(Long id);
    Type_Courrier getOneType_Courrier(Long id);
}

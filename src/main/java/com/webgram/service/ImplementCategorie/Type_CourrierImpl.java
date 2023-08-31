package com.webgram.service.ImplementCategorie;

import com.webgram.dao.Type_CourrierRepository;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.IType_Courrier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Dans chaque service il est impératif davoir lanotation @Service
@RequiredArgsConstructor
//permet de faire l'injection de dépendance par constructeur DE la variable type_courrierRepository qui permet d'inter-agir avec la base en utilisant des methodes comme save(),getAllCategorie()etc..
public class Type_CourrierImpl implements IType_Courrier {
    private final Type_CourrierRepository type_courrierRepository;
    @Override
    public Type_Courrier addType_Courrier(Type_Courrier type_courrier) {
        return type_courrierRepository.save(type_courrier);
    }

    @Override
    public List<Type_Courrier> getAllType_Courrier() {
        return type_courrierRepository.getAllType_Courrier();
    }

    @Override
    public Type_Courrier updateType_Courrier(Long id, Type_Courrier type_courrier) {
        Type_Courrier existingTypecour=getOneType_Courrier(id);
        //existingTypecour.setType(type_courrier.getType());
        existingTypecour.setLibelle(type_courrier.getLibelle());
        return type_courrierRepository.save(existingTypecour);
    }

    @Override
    public void deletedType_Courrier(Long id) {
        Type_Courrier existingTypecour=getOneType_Courrier(id);
        type_courrierRepository.delete (existingTypecour);
    }

    @Override
    public Type_Courrier getOneType_Courrier(Long id) {
        return type_courrierRepository.findById(id).orElseThrow(()->new RuntimeException("La typecourrier recherché n'existe pas"));
    }
}

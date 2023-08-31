package com.webgram.service.ImplementCategorie;

import com.webgram.dao.ETATRepository;
import com.webgram.dao.EmployeeRepository;
import com.webgram.dao.Type_CourrierRepository;
import com.webgram.entity.ETAT;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.IETAT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //Dans chaque service il est impératif davoir lanotation @Service
@RequiredArgsConstructor
//permet de faire l'injection de dépendance par constructeur DE la variable type_courrierRepository qui permet d'inter-agir avec la base en utilisant des methodes comme save(),getAllCategorie()etc..
public class ETATImpl implements IETAT {
    private final ETATRepository etatRepository;
    @Override
    public ETAT addETAT(ETAT etat) {
        return etatRepository.save(etat);
    }

    @Override
    public List<ETAT> getAllETAT() {
        return etatRepository.getAllETAT();
    }

    @Override
    public ETAT updateETAT(Long id, ETAT etat) {
        ETAT existingETAT=getOneETAT(id);
        //existingETAT.setNature_etat(etat.getNature_etat());
        existingETAT.setLibelle(etat.getLibelle());
        return etatRepository.save(existingETAT);
    }

    @Override
    public void deletedETAT(Long id) {
        ETAT existingETAT=getOneETAT(id);
        etatRepository.delete (existingETAT);
    }

    @Override
    public ETAT getOneETAT(Long id) {
        return etatRepository.findById(id).orElseThrow(()->new RuntimeException("L'etat recherché n'existe pas"));
    }
}

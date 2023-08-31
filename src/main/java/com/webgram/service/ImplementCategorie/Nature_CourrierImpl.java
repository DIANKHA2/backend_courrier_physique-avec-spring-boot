package com.webgram.service.ImplementCategorie;

import com.webgram.dao.Nature_CourrierRepository;
import com.webgram.entity.Nature_Courrier;
import com.webgram.service.INature_Courrier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Dans chaque service il est impératif davoir lanotation @Service
@RequiredArgsConstructor
//permet de faire l'injection de dépendance par constructeur qui permet d'inter-agir avec la base en utilisant des methodes comme save(),getAllCategorie()etc..

public class Nature_CourrierImpl implements INature_Courrier {
    private final Nature_CourrierRepository nature_courrierRepository; //variable utilisés pour gérer l'injection de dépendance par constructeur de type la classe qui etend jparepository
    @Override
    public Nature_Courrier addNature_Courrier(Nature_Courrier nature_courrier) {
        return nature_courrierRepository.save(nature_courrier);
    }

    @Override
    public List<Nature_Courrier> getAllNature_Courrier() {
        return nature_courrierRepository.getAllNature_Courrier();
    }

    @Override
    public Nature_Courrier updateNature_Courrier(Long id, Nature_Courrier nature_courrier) {
        Nature_Courrier existingNature_Courrier=getOneNature_Courrier(id);
        //existingNature_Courrier.setNature(nature_courrier.getNature());
        existingNature_Courrier.setLibelle(nature_courrier.getLibelle());
        return nature_courrierRepository.save(existingNature_Courrier);
    }

    @Override
    public void deletedNature_Courrier(Long id) {
        Nature_Courrier existingNature_Courrier=getOneNature_Courrier(id);
        nature_courrierRepository.delete (existingNature_Courrier);

    }

    @Override
    public Nature_Courrier getOneNature_Courrier(Long id) {
        return nature_courrierRepository.findById(id).orElseThrow(()->new RuntimeException("La naturecourrier recherché n'existe pas"));
    }
}

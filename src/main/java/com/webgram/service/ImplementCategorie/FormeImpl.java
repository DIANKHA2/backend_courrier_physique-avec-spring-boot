package com.webgram.service.ImplementCategorie;

import com.webgram.dao.ETATRepository;
import com.webgram.dao.FormeRepository;
import com.webgram.entity.ETAT;
import com.webgram.entity.Forme;
import com.webgram.service.IForme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Dans chaque service il est impératif davoir lanotation @Service
@RequiredArgsConstructor
public class FormeImpl implements IForme {
    private final FormeRepository formeRepository;

    @Override
    public Forme addForme(Forme forme) {
        return formeRepository.save(forme);
    }

    @Override
    public List<Forme> getAllForme() {
        return formeRepository.getAllForme();
    }

    @Override
    public Forme updateForme(Long id, Forme forme) {
       Forme existingForme=getOneForme(id);
        //existingF.setNature_etat(etat.getNature_etat());
        existingForme.setLibelle(forme.getLibelle());
        return formeRepository.save(existingForme);
    }

    @Override
    public void deletedForme(Long id) {
       Forme existingForme=getOneForme(id);
        formeRepository.delete (existingForme);

    }

    @Override
    public Forme getOneForme(Long id) {
        return formeRepository.findById(id).orElseThrow(()->new RuntimeException("La forme de courrier recherché n'existe pas"));
    }
}

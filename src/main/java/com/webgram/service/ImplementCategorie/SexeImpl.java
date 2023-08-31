package com.webgram.service.ImplementCategorie;

import com.webgram.dao.SexeRepository;
import com.webgram.dao.Type_CourrierRepository;
import com.webgram.entity.Sexe;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.ISexe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Dans chaque service il est impératif davoir lanotation @Service
@RequiredArgsConstructor
public class SexeImpl implements ISexe {
    private final SexeRepository sexeRepository;
    @Override
    public Sexe addSexe(Sexe sexe) {
        return sexeRepository.save(sexe);
    }

    @Override
    public List<Sexe> getAllSexe() {
        return sexeRepository.getAllSexe();
    }

    @Override
    public Sexe updateSexe(Long id, Sexe sexe) {
        Sexe existingSexe=getOneSexe(id);
        //existingSexe.setGenre(sexe.getGenre());
        //existingSexe.setLibelle(sexe.getLibelle());
        existingSexe.setGenre(sexe.getGenre());
        return sexeRepository.save(existingSexe);
    }

    @Override
    public void deletedSexe(Long id) {
        Sexe existingSexe=getOneSexe(id);
        sexeRepository.delete (existingSexe);
    }

    @Override
    public Sexe getOneSexe(Long id) {
        return sexeRepository.findById(id).orElseThrow(()->new RuntimeException("Le genre de sexe recherché n'existe pas"));
    }
}

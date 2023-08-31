package com.webgram.service.ImplementCategorie;

import com.webgram.dao.*;
import com.webgram.entity.COURRIER;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.ICOURRIER;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Dans chaque service il est impératif davoir lanotation @Service
@RequiredArgsConstructor
public class COURRIERImpl implements ICOURRIER {
    private final COURRIERRepository courrierRepository;
    private final ETATRepository etatRepository;
    private final Nature_CourrierRepository nature_courrierRepository;
    private final Type_CourrierRepository type_courrierRepository;
    private final FormeRepository formeRepository;

    @Override
    public COURRIER addCOURRIER(COURRIER courrier) {
        val etat  = etatRepository.findByLibelle(courrier.getEtat_courrier().getLibelle());
        val nature  = nature_courrierRepository.findByLibelle(courrier.getNature_courrier().getLibelle());
        val type  = type_courrierRepository.findByLibelle(courrier.getType_courrier().getLibelle());
        val forme  = formeRepository.findByLibelle(courrier.getForme_courrier().getLibelle());
       // val employee  = employeeRepository.findByemployee(courrier.getEmployee().getUser_emplid());
        var savedETAT = COURRIER.builder()
                .ref(courrier.getRef())
                .date_arrivée(courrier.getDate_arrivée())
                .détails(courrier.getDétails())
                .Objet(courrier.getObjet())
                .employee(courrier.getEmployee())
                .etat_courrier(etat)
                .nature_courrier(nature)
                .type_courrier(type)
                .forme_courrier(forme).build();
        return courrierRepository.save(savedETAT);
    }

    @Override
    public List<COURRIER> getAllCOURRIER() {
        return courrierRepository.getAllCOURRIER();
    }

    @Override
    public COURRIER updateCOURRIER(Long id, COURRIER courrier) {
        val nature  = nature_courrierRepository.findByLibelle(courrier.getNature_courrier().getLibelle());
        val etat  = etatRepository.findByLibelle(courrier.getEtat_courrier().getLibelle());
        val type  = type_courrierRepository.findByLibelle(courrier.getType_courrier().getLibelle());
        val forme  = formeRepository.findByLibelle(courrier.getForme_courrier().getLibelle());
      // val employee  = employeeRepository.findByemployee(courrier.getEmployee().getUser_emplid());
       COURRIER existingCOURRIER=getOneCOURRIER(id);
        existingCOURRIER.setRef(courrier.getRef());
        existingCOURRIER.setDate_arrivée(courrier.getDate_arrivée());
        existingCOURRIER.setDétails(courrier.getDétails());
        existingCOURRIER.setObjet(courrier.getObjet());
       existingCOURRIER.setEmployee(courrier.getEmployee());
        existingCOURRIER.setEtat_courrier(etat);
        existingCOURRIER.setNature_courrier(nature);
        existingCOURRIER.setType_courrier(type);
        existingCOURRIER.setForme_courrier(forme);
        return courrierRepository.save(existingCOURRIER);
    }

    @Override
    public void deletedCOURRIER(Long id) {
        COURRIER existingCOURRIER=getOneCOURRIER(id);
        courrierRepository.delete (existingCOURRIER);

    }

    @Override
    public COURRIER getOneCOURRIER(Long id) {
        return courrierRepository.findById(id).orElseThrow(()->new RuntimeException("Le courrier recherché n'existe pas"));
    }
}

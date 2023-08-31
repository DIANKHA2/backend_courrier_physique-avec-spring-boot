package com.webgram.service.ImplementCategorie;

import com.webgram.dao.CorrespondantRepository;
import com.webgram.dao.Type_CourrierRepository;
import com.webgram.entity.Correspondant;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.ICorrespondant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Dans chaque service il est impératif davoir lanotation @Service
@RequiredArgsConstructor
public class CorrespondantImpl implements ICorrespondant {
    private final CorrespondantRepository correspondantRepository;
    @Override
    public Correspondant addCorrespondant(Correspondant correspondant) {
        return correspondantRepository.save(correspondant);
    }

    @Override
    public List<Correspondant> getAllCorrespondant() {
        return correspondantRepository.getAllCorrespondant();
    }

    @Override
    public Correspondant updateCorrespondant(Long id, Correspondant correspondant) {
        Correspondant existingCorrespondant=getOneCorrespondant(id);
        existingCorrespondant.setMat_Correp(correspondant.getMat_Correp());
        existingCorrespondant.setNom_Correp(correspondant.getNom_Correp());
        existingCorrespondant.setFonction_Correp(correspondant.getFonction_Correp());
        existingCorrespondant.setAdress_corresp(correspondant.getAdress_corresp());
        existingCorrespondant.setTél_corresp(correspondant.getTél_corresp());
        existingCorrespondant.setE_mail_corrsp(correspondant.getE_mail_corrsp());
        existingCorrespondant.setFax_corrsp(correspondant.getFax_corrsp());
        return correspondantRepository.save(existingCorrespondant);
    }

    @Override
    public void deletedCorrespondant(Long id) {
        Correspondant existingCorrespondant=getOneCorrespondant(id);
        correspondantRepository.delete (existingCorrespondant);

    }

    @Override
    public Correspondant getOneCorrespondant(Long id) {
        return correspondantRepository.findById(id).orElseThrow(()->new RuntimeException("Le correspondant recherché n'existe pas"));
    }
}

package com.webgram.service.ImplementCategorie;

import com.webgram.dao.Copie_ScaneeReporisitory;
import com.webgram.dao.Type_CourrierRepository;
import com.webgram.entity.Copie_Scanee;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.ICopie_Scanee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Dans chaque service il est impératif davoir lanotation @Service
@RequiredArgsConstructor
public class Copie_ScaneeImpl implements ICopie_Scanee {
    private final Copie_ScaneeReporisitory copie_scaneeReporisitory;
    @Override
    public Copie_Scanee addCopie_Scanee(Copie_Scanee copie_scanee) {
        return copie_scaneeReporisitory.save(copie_scanee);
    }

    @Override
    public List<Copie_Scanee> getAllCopie_Scanee() {
        return copie_scaneeReporisitory.getAllCopie_Scanee();
    }

    @Override
    public Copie_Scanee updateCopie_Scanee(Long id, Copie_Scanee copie_scanee) {
        Copie_Scanee existingCopie_Scanee=getOneCopie_Scanee(id);
        existingCopie_Scanee.setCopie(copie_scanee.getCopie());
        existingCopie_Scanee.setCommentaire_copie(copie_scanee.getCommentaire_copie());
        existingCopie_Scanee.setDate_scan(copie_scanee.getDate_scan());
        existingCopie_Scanee.setCourrier(copie_scanee.getCourrier());
        return copie_scaneeReporisitory.save(existingCopie_Scanee);
    }

    @Override
    public void deletedCopie_Scanee(Long id) {
        Copie_Scanee existingCopie_Scanee=getOneCopie_Scanee(id);
        copie_scaneeReporisitory.delete (existingCopie_Scanee);
    }

    @Override
    public Copie_Scanee getOneCopie_Scanee(Long id) {
        return copie_scaneeReporisitory.findById(id).orElseThrow(()->new RuntimeException("Le CopieScan recherché n'existe pas"));
    }
}

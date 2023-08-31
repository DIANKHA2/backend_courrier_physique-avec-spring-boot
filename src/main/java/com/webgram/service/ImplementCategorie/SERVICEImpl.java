package com.webgram.service.ImplementCategorie;

import com.webgram.dao.SERVICERepository;
import com.webgram.dao.Type_CourrierRepository;
import com.webgram.entity.SERVICE;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.ISERVICE;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Dans chaque service il est impératif davoir lanotation @Service
@RequiredArgsConstructor
public class SERVICEImpl implements ISERVICE {
    private final SERVICERepository serviceRepository;
    @Override
    public SERVICE addSERVICE(SERVICE service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<SERVICE> getAllSERVICE() {
        return serviceRepository.getAllSERVICE();
    }

    @Override
    public SERVICE updateSERVICE(Long id, SERVICE service) {
        SERVICE existingSERVICE=getOneSERVICE(id);
        existingSERVICE.setNom_service(service.getNom_service());
        existingSERVICE.setResponsable(service.getResponsable());
        existingSERVICE.setTel_Service(service.getTel_Service());
        existingSERVICE.setE_mail_Service(service.getE_mail_Service());
        return serviceRepository.save(existingSERVICE);
    }

    @Override
    public void deletedSERVICE(Long id) {
        SERVICE existingSERVICE=getOneSERVICE(id);
        serviceRepository.delete (existingSERVICE);
    }

    @Override
    public SERVICE getOneSERVICE(Long id) {
        return serviceRepository.findById(id).orElseThrow(()->new RuntimeException("Le service recherché n'existe pas"));
    }
}

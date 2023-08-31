package com.webgram.web;

import com.webgram.entity.SERVICE;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.ImplementCategorie.SERVICEImpl;
import com.webgram.service.ImplementCategorie.Type_CourrierImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
//Une api permet a nimporte quelle interface front(mobile ou web postman) d'accéder a nos methodess serviceimpl
@RequiredArgsConstructor
//permet de faire l'injection de dépendance par constructeur qui permet d'inter-agir avec la base en utilisant des methodes comme save(),getAllCategorie()etc.. Mais pour ce cas comme nous avions déja mentionné save() et get.. dans la classe service on crée juste une variable de type la classe de service et on appelle les méthode api pour le crud
//@RequestMapping permet de nous faciliter la tache dans les url de @PostMapping("/api/webgram/v1//addcategorie")
@RequestMapping("/api/webgram/v1")

public class SERVICEController {
    private final SERVICEImpl serviceimpl;

    @PostMapping("/addSERVICE")
    public ResponseEntity<SERVICE> newSERVICE(@RequestBody SERVICE service){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour ajouter des categorie dans la base
        SERVICE ser=serviceimpl.addSERVICE(service);
        return ResponseEntity.status(HttpStatus.CREATED).body(ser);
    }
    @GetMapping("/listSERVICE")
    public ResponseEntity<List<SERVICE>> listSERVICE(){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour lister des categorie dans la base
        return ResponseEntity.ok(serviceimpl.getAllSERVICE());
    }

    @PutMapping("/updateSERVICE/{id}")
    public ResponseEntity<SERVICE> updateSERVICE(@PathVariable Long id, @RequestBody SERVICE service){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour updater des categorie dans la base
        SERVICE cat=serviceimpl.updateSERVICE(id, service);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cat);
    }
    @DeleteMapping("/deleteSERVICE/{id}")
    public ResponseEntity<SERVICE> deleteSERVICE(@PathVariable Long id){
        serviceimpl.deletedSERVICE(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getOneSERVICE/{id}")
    public ResponseEntity<SERVICE> getSERVICEById(@PathVariable Long id){
        return ResponseEntity.ok(serviceimpl.getOneSERVICE(id));
    }
}

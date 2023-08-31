package com.webgram.web;

import com.webgram.entity.Correspondant;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.ImplementCategorie.CorrespondantImpl;
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

public class CorrespondantController {
    private final CorrespondantImpl correspondantimpl;

    @PostMapping("/addcorrespondant")
    public ResponseEntity<Correspondant> newcorrespondant(@RequestBody Correspondant correspondant){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour ajouter des categorie dans la base
        Correspondant crsp=correspondantimpl.addCorrespondant(correspondant);
        return ResponseEntity.status(HttpStatus.CREATED).body(crsp);
    }
    @GetMapping("/listcorrespondant")
    public ResponseEntity<List<Correspondant>> listcorrespondant(){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour lister des categorie dans la base
        return ResponseEntity.ok(correspondantimpl.getAllCorrespondant());
    }

    @PutMapping("/updatecorrespondant/{id}")
    public ResponseEntity<Correspondant> updatecorrespondant(@PathVariable Long id, @RequestBody Correspondant correspondant){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour updater des categorie dans la base
        Correspondant crsp=correspondantimpl.updateCorrespondant(id, correspondant);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(crsp);
    }
    @DeleteMapping("/deletecorrespondant/{id}")
    public ResponseEntity<Correspondant> deletecorrespondant(@PathVariable Long id){
        correspondantimpl.deletedCorrespondant(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getOnecorrespondant/{id}")
    public ResponseEntity<Correspondant> getcorrespondantById(@PathVariable Long id){
        return ResponseEntity.ok(correspondantimpl.getOneCorrespondant(id));
    }

}

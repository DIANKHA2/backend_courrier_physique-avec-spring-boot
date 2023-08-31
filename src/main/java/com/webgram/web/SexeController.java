package com.webgram.web;

import com.webgram.entity.Sexe;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.ImplementCategorie.SexeImpl;
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

public class SexeController {
    private final SexeImpl sexeimpl;

    @PostMapping("/addSexe")
    public ResponseEntity<Sexe> newSexe(@RequestBody Sexe sexe){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour ajouter des categorie dans la base
        Sexe sex=sexeimpl.addSexe(sexe);
        return ResponseEntity.status(HttpStatus.CREATED).body(sex);
    }
    @GetMapping("/listSexe")
    public ResponseEntity<List<Sexe>> listSexe(){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour lister des categorie dans la base
        return ResponseEntity.ok(sexeimpl.getAllSexe());
    }

    @PutMapping("/updateSexe/{id}")
    public ResponseEntity<Sexe> updateSexe(@PathVariable Long id, @RequestBody Sexe sexe){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour updater des categorie dans la base
       Sexe sex=sexeimpl.updateSexe(id, sexe);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(sex);
    }
    @DeleteMapping("/deleteSexe/{id}")
    public ResponseEntity<Sexe> deleteSexe(@PathVariable Long id){
        sexeimpl.deletedSexe(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getOneSexe/{id}")
    public ResponseEntity<Sexe> getSexeById(@PathVariable Long id){
        return ResponseEntity.ok(sexeimpl.getOneSexe(id));
    }
}

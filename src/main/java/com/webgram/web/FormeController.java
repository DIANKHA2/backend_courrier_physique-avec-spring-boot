package com.webgram.web;

import com.webgram.entity.ETAT;
import com.webgram.entity.Forme;
import com.webgram.service.ImplementCategorie.ETATImpl;
import com.webgram.service.ImplementCategorie.FormeImpl;
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
public class FormeController {
    private final FormeImpl formeimpl;
    @PostMapping("/addForme")
    public ResponseEntity<Forme> newForme(@RequestBody Forme forme){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour ajouter des categorie dans la base
        Forme et=formeimpl.addForme(forme);
        return ResponseEntity.status(HttpStatus.CREATED).body(et);
    }
    @GetMapping("/listForme")
    public ResponseEntity<List<Forme>> listForme(){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour lister des categorie dans la base
        return ResponseEntity.ok(formeimpl.getAllForme());
    }

    @PutMapping("/updateForme/{id}")
    public ResponseEntity<Forme> updateForme(@PathVariable Long id, @RequestBody Forme forme){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour updater des categorie dans la base
        Forme et=formeimpl.updateForme(id, forme);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(et);
    }
    @DeleteMapping("/deleteForme/{id}")
    public ResponseEntity<Forme> deleteForme(@PathVariable Long id){
        formeimpl.deletedForme(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getOneForme/{id}")
    public ResponseEntity<Forme> getFormeById(@PathVariable Long id){
        return ResponseEntity.ok(formeimpl.getOneForme(id));
    }
}
package com.webgram.web;

import com.webgram.entity.Copie_Scanee;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.ImplementCategorie.Copie_ScaneeImpl;
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
public class Copie_ScaneeController {
    private final Copie_ScaneeImpl copie_scaneeimpl;

    @PostMapping("/addCopie_Scanee")
    public ResponseEntity<Copie_Scanee> newCopie_Scanee(@RequestBody Copie_Scanee copie_scanee){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour ajouter des categorie dans la base
        Copie_Scanee COPISC=copie_scaneeimpl.addCopie_Scanee(copie_scanee);
        return ResponseEntity.status(HttpStatus.CREATED).body(COPISC);
    }
    @GetMapping("/listCopie_Scanee")
    public ResponseEntity<List<Copie_Scanee>> listCopie_Scanee(){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour lister des categorie dans la base
        return ResponseEntity.ok(copie_scaneeimpl.getAllCopie_Scanee());
    }

    @PutMapping("/updateCopie_Scanee/{id}")
    public ResponseEntity<Copie_Scanee> updateCopie_Scanee(@PathVariable Long id, @RequestBody Copie_Scanee copie_scanee){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour updater des categorie dans la base
        Copie_Scanee COPISC =copie_scaneeimpl.updateCopie_Scanee(id,copie_scanee);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(COPISC);
    }
    @DeleteMapping("/deleteCopie_Scanee/{id}")
    public ResponseEntity<Copie_Scanee> deleteCopie_Scanee(@PathVariable Long id){
        copie_scaneeimpl.deletedCopie_Scanee(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getOneCopie_Scanee/{id}")
    public ResponseEntity<Copie_Scanee> getCopie_ScaneeById(@PathVariable Long id){
        return ResponseEntity.ok(copie_scaneeimpl.getOneCopie_Scanee(id));
    }
}

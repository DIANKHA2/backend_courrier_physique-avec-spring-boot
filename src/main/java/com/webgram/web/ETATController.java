package com.webgram.web;

import com.webgram.entity.ETAT;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.ImplementCategorie.ETATImpl;
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

public class ETATController {
    private final ETATImpl etatimpl;

    @PostMapping("/addETAT")
    public ResponseEntity<ETAT> newETAT(@RequestBody ETAT etat){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour ajouter des categorie dans la base
        ETAT et=etatimpl.addETAT(etat);
        return ResponseEntity.status(HttpStatus.CREATED).body(et);
    }
    @GetMapping("/listETAT")
    public ResponseEntity<List<ETAT>> listETAT(){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour lister des categorie dans la base
        return ResponseEntity.ok(etatimpl.getAllETAT());
    }

    @PutMapping("/updateETAT/{id}")
    public ResponseEntity<ETAT> updateETAT(@PathVariable Long id, @RequestBody ETAT etat){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour updater des categorie dans la base
        ETAT et=etatimpl.updateETAT(id, etat);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(et);
    }
    @DeleteMapping("/deleteETAT/{id}")
    public ResponseEntity<ETAT> deleteETAT(@PathVariable Long id){
        etatimpl.deletedETAT(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getOneETAT/{id}")
    public ResponseEntity<ETAT> getETATById(@PathVariable Long id){
        return ResponseEntity.ok(etatimpl.getOneETAT(id));
    }

}

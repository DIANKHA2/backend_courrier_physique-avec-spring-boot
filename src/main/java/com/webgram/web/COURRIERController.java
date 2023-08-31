package com.webgram.web;

import com.webgram.entity.COURRIER;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.ImplementCategorie.COURRIERImpl;
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

public class COURRIERController {
    private final COURRIERImpl courrierimpl;

    @PostMapping("/addCOURRIER")
    public ResponseEntity<COURRIER> newCOURRIER(@RequestBody COURRIER courrier){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour ajouter des categorie dans la base
        COURRIER COR=courrierimpl.addCOURRIER(courrier);
        return ResponseEntity.status(HttpStatus.CREATED).body(COR);
    }
    @GetMapping("/listCOURRIER")
    public ResponseEntity<List<COURRIER>> listCOURRIER(){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour lister des categorie dans la base
        return ResponseEntity.ok(courrierimpl.getAllCOURRIER());
    }

    @PutMapping("/updateCOURRIER/{id}")
    public ResponseEntity<COURRIER> updateCOURRIER(@PathVariable Long id, @RequestBody COURRIER courrier){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour updater des categorie dans la base
        COURRIER COR=courrierimpl.updateCOURRIER(id, courrier);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(COR);
    }
    @DeleteMapping("/deleteCOURRIER/{id}")
    public ResponseEntity<COURRIER> deleteCOURRIER(@PathVariable Long id){
        courrierimpl.deletedCOURRIER(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getOneCOURRIER/{id}")
    public ResponseEntity<COURRIER> getCOURRIERById(@PathVariable Long id){
        return ResponseEntity.ok(courrierimpl.getOneCOURRIER(id));
    }

}

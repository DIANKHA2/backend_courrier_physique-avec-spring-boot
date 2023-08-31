package com.webgram.web;

import com.webgram.entity.Nature_Courrier;
import com.webgram.service.ImplementCategorie.Nature_CourrierImpl;
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

public class NatureCourrierController {
    private final Nature_CourrierImpl nature_courrierimpl;

    @PostMapping("/addNature_Courrier")
    public ResponseEntity<Nature_Courrier> newNature_Courrier(@RequestBody Nature_Courrier nature_courrier){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour ajouter des categorie dans la base
        Nature_Courrier natcour=nature_courrierimpl.addNature_Courrier(nature_courrier) ;
        return ResponseEntity.status(HttpStatus.CREATED).body(natcour);
    }
    @GetMapping("/listNature_Courrier")
    public ResponseEntity<List<Nature_Courrier>> listNature_Courrier(){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour lister des categorie dans la base
        return ResponseEntity.ok(nature_courrierimpl.getAllNature_Courrier());
    }

    @PutMapping("/updateNature_Courrier/{id}")
    public ResponseEntity<Nature_Courrier> updateNature_Courrier(@PathVariable Long id, @RequestBody Nature_Courrier nature_courrier){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour updater des categorie dans la base
        Nature_Courrier natcour=nature_courrierimpl.updateNature_Courrier(id,nature_courrier);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(natcour);
    }

    @DeleteMapping("/deleteNature_Courrier/{id}")
    public ResponseEntity<Nature_Courrier> deleteNature_Courrier(@PathVariable Long id){
        nature_courrierimpl.deletedNature_Courrier(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getOneNature_Courrier/{id}")
    public ResponseEntity<Nature_Courrier> getNature_CourrierById(@PathVariable Long id){
        return ResponseEntity.ok(nature_courrierimpl.getOneNature_Courrier(id));
    }
}

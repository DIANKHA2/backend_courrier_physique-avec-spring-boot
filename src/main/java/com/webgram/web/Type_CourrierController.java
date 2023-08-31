package com.webgram.web;

import com.webgram.entity.Type_Courrier;
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

public class Type_CourrierController {
    private final Type_CourrierImpl type_courrierImpl;

    @PostMapping("/addtypecour")
    public ResponseEntity<Type_Courrier> newtypecour(@RequestBody Type_Courrier type_courrier){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour ajouter des categorie dans la base
        Type_Courrier typecour=type_courrierImpl.addType_Courrier(type_courrier);
        return ResponseEntity.status(HttpStatus.CREATED).body(typecour);
    }
    @GetMapping("/listtypecour")
    public ResponseEntity<List<Type_Courrier>> listtypecour(){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour lister des categorie dans la base
        return ResponseEntity.ok(type_courrierImpl.getAllType_Courrier());
    }

    @PutMapping("/updatetypecour/{id}")
    public ResponseEntity<Type_Courrier> updatecategorie(@PathVariable Long id, @RequestBody Type_Courrier type_courrier){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour updater des categorie dans la base
        Type_Courrier cat=type_courrierImpl.updateType_Courrier(id,type_courrier);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cat);
    }
    @DeleteMapping("/deletetypecour/{id}")
        public ResponseEntity<Type_Courrier> deletetypecour(@PathVariable Long id){
            type_courrierImpl.deletedType_Courrier(id);
            return ResponseEntity.noContent().build();
        }


    @GetMapping("/getOnetypecour/{id}")
    public ResponseEntity<Type_Courrier> gettypecourById(@PathVariable Long id){
        return ResponseEntity.ok(type_courrierImpl.getOneType_Courrier(id));
    }

}

package com.webgram.web;

import com.webgram.entity.Employee;
import com.webgram.entity.Type_Courrier;
import com.webgram.service.ImplementCategorie.EmployeeImpl;
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

public class EmployeeController {
    private final EmployeeImpl employeeimpl;

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> newEmployee(@RequestBody Employee employee){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour ajouter des categorie dans la base
        Employee emp=employeeimpl.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(emp);
    }
    @GetMapping("/listEmployee")
    public ResponseEntity<List<Employee>> listEmployee(){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour lister des categorie dans la base
        return ResponseEntity.ok(employeeimpl.getAllEmployee());
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        //c'est la methode qu'utiliserons les interface front(mobile ou web ou postman) pour updater des categorie dans la base
        Employee emp=employeeimpl.updateEmployee(id, employee);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(emp);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
        employeeimpl.deletedEmployee(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getOneEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeimpl.getOneEmployee(id));
    }

}

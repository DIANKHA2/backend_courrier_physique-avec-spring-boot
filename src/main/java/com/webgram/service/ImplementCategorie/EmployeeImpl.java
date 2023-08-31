package com.webgram.service.ImplementCategorie;

import com.webgram.dao.*;
import com.webgram.entity.*;
import com.webgram.service.IEmployee;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Dans chaque service il est impératif davoir lanotation @Service
@RequiredArgsConstructor
public class EmployeeImpl implements IEmployee {
    private final EmployeeRepository employeeRepository;
    private final SexeRepository sexeRepository;

    public Employee addEmployee(Employee employee) {
       // val sexe  = sexeRepository.findByLibelle(employee.getSexe().getLibelle());
        Sexe sexe =new Sexe();
        var savedemployee = Employee.builder()
                .Mat_employe(employee.getMat_employe())
                .Nom_employe(employee.getNom_employe())
                .Fonction_employé(employee.getFonction_employé())
                .CIN_employé(employee.getCIN_employé())
                .Adress_employé(employee.getAdress_employé())
                .Tél__employe(employee.getTél__employe())
                .Date_embauche_employe(employee.getDate_embauche_employe())
                .Date_naissance_employe(employee.getDate_naissance_employe())
                .service(employee.)
                .sexe(sexe.setGenre();).build();
        return employeeRepository.save(savedemployee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

       Employee existingEmployee=getOneEmployee(id);
        existingEmployee.setMat_employe(employee.getMat_employe());
        existingEmployee.setNom_employe(employee.getNom_employe());
        existingEmployee.setFonction_employé(employee.getFonction_employé());
        existingEmployee.setCIN_employé(employee.getCIN_employé());
        existingEmployee.setAdress_employé(employee.getAdress_employé());
        existingEmployee.setTél__employe(employee.getTél__employe());
        existingEmployee.setDate_naissance_employe(employee.getDate_naissance_employe());
        existingEmployee.setDate_embauche_employe(employee.getDate_embauche_employe());
        existingEmployee.setService(employee.getService().);
        existingEmployee.setSexe(employee.getSexe());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deletedEmployee(Long id) {
        Employee existingEmployee=getOneEmployee(id);
        employeeRepository.delete (existingEmployee);

    }

    @Override
    public Employee getOneEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("l'employee recherché n'existe pas"));
    }
}

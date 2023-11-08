package com.pharmashop.api.controller;

import com.pharmashop.api.model.Employe;
import com.pharmashop.api.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*") //Donner l'accès aux controllers à travers le client http
@RestController
@RequestMapping(path = "/api/v1/rest", name = "app_employes")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    //Créer un employé
    @PostMapping(path = "/employes", name = "create")
    @ResponseStatus(HttpStatus.CREATED )
    public Employe add(@RequestBody Employe employe){
        return employeService.saveEmploye(employe);
    }

    //Recuperer la liste des employes
    @GetMapping(path = "/employes", name = "list")
    @ResponseStatus(HttpStatus.OK)
    public List<Employe> list(){
        return employeService.getAllEmploye();
    }

    //Recuperer employe specifique par son id
    @GetMapping(path = "/employes/{id}", name = "read")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employe> read(@PathVariable Long id){
        return employeService.getOneEmploye(id);
    }

    //Modifier un employe
    @PutMapping(path = "/employes/{id}", name="update")
    @ResponseStatus(HttpStatus.OK)
    public Employe update(@RequestBody Employe employe, @PathVariable Long id){
        return employeService.updateEmploye(employe, id);
    }

    //Supprimer un employe
    @DeleteMapping(path = "/employes/{id}", name="remove")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable Long id){
        employeService.removeEmploye(id);
    }
}

package com.pharmashop.api.service;

import com.pharmashop.api.exceptions.EmployeNotFoundException;
import com.pharmashop.api.model.Employe;
import com.pharmashop.api.repository.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    public Employe saveEmploye(Employe employe){
        return employeRepository.save(employe);
    }

    public List<Employe> getAllEmploye(){
        return employeRepository.findAll();
    }

    public Optional<Employe> getOneEmploye(Long id){
        Optional<Employe> employe = employeRepository.findById(id);
        if(!employe.isPresent()){
            //Lever une exception
            throw new EmployeNotFoundException(String.format("Employe with %s not found!" + id));
        }
        return employeRepository.findById(id);
    }

    public Employe updateEmploye(Employe employe, Long id){
        Optional<Employe> employeExist = employeRepository.findById(id);
        if(!employeExist.isPresent()){
            //Lever une exception
            throw new EmployeNotFoundException(String.format("Employe with %s not found!" + id));
        }

        return employeRepository.save(employe);
    }

    public void removeEmploye(Long id){
        Optional<Employe> employe = employeRepository.findById(id);
        if(!employe.isPresent()){
            //Lever une exception
            throw new EmployeNotFoundException(String.format("Employe with %s not found!" + id));
        }

        employeRepository.delete(employe.get());
    }
}

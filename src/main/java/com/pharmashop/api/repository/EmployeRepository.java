package com.pharmashop.api.repository;

import com.pharmashop.api.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {

}

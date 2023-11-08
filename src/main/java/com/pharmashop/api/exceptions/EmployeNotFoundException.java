package com.pharmashop.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Methode pour dire que la donnée n'as pas eté trouvée
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeNotFoundException extends RuntimeException {
    public EmployeNotFoundException(String message){
        super(message);
    }
}

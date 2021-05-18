package ead.dio.bootcamp.codeanywhere.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(Long id) {
        super("Person with ID ["+id+"] NOT FOUND");
    }

    public PersonNotFoundException(String cpf) {
        super("Person with CPF ["+cpf+"] NOT FOUND");
    }
}
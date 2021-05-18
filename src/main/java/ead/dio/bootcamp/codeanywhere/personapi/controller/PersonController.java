package ead.dio.bootcamp.codeanywhere.personapi.controller;

import ead.dio.bootcamp.codeanywhere.personapi.dto.PersonDTO;
import ead.dio.bootcamp.codeanywhere.personapi.exception.PersonNotFoundException;
import ead.dio.bootcamp.codeanywhere.personapi.messages.PersonMessageResponse;
import ead.dio.bootcamp.codeanywhere.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonMessageResponse createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @PutMapping("/{id}")
    public PersonMessageResponse updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO)  throws PersonNotFoundException{
        return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException{
        personService.delete(id);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public PersonDTO findByCpf(@PathVariable String cpf)  {
        return personService.findByCpf(cpf);
    }
}
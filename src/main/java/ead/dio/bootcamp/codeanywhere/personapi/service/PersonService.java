package ead.dio.bootcamp.codeanywhere.personapi.service;

import ead.dio.bootcamp.codeanywhere.personapi.dto.PersonDTO;
import ead.dio.bootcamp.codeanywhere.personapi.entity.Person;
import ead.dio.bootcamp.codeanywhere.personapi.exception.PersonNotFoundException;
import ead.dio.bootcamp.codeanywhere.personapi.mapper.PersonMapper;
import ead.dio.bootcamp.codeanywhere.personapi.messages.PersonMessageResponse;
import ead.dio.bootcamp.codeanywhere.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private PersonRepository personRepository;

    public PersonMessageResponse createPerson(PersonDTO personDTO){
        Person toSaved     = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(toSaved);
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    public PersonMessageResponse updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person toUpdate     = personMapper.toModel(personDTO);
        Person updatePerson = personRepository.save(toUpdate);
        return createMessageResponse(updatePerson.getId(), "Update person with ID ");
    }

    public void delete(Long id) throws PersonNotFoundException{
        Person person = verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public PersonDTO findByCpf(String cpf) {
        Person person = personRepository.findByCpf(cpf);
        if (person == null){
            new PersonNotFoundException(cpf);
        }

        return personMapper.toDTO(person);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    private PersonMessageResponse createMessageResponse(Long id, String message) {
        return PersonMessageResponse.builder().message(message + id).build();
    }
}
package ead.dio.bootcamp.codeanywhere.personapi.services;

import ead.dio.bootcamp.codeanywhere.personapi.dto.PersonDTO;
import ead.dio.bootcamp.codeanywhere.personapi.entity.Person;
import ead.dio.bootcamp.codeanywhere.personapi.mapper.PersonMapper;
import ead.dio.bootcamp.codeanywhere.personapi.messages.PersonMessageResponse;
import ead.dio.bootcamp.codeanywhere.personapi.repository.PersonRepository;
import ead.dio.bootcamp.codeanywhere.personapi.service.PersonService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static ead.dio.bootcamp.codeanywhere.personapi.utils.PersonUtils.createFakeDTO;
import static ead.dio.bootcamp.codeanywhere.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    @Mock
    private PersonMapper personMapper;
    @InjectMocks
    private PersonService personService;
    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        PersonMessageResponse expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        PersonMessageResponse successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private PersonMessageResponse createExpectedSuccessMessage(Long savedPersonId) {
        return PersonMessageResponse.builder()
                .message("Person successfully created with ID " + savedPersonId)
                .build();
    }
}
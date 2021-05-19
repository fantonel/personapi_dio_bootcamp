package ead.dio.bootcamp.codeanywhere.personapi.service;

import ead.dio.bootcamp.codeanywhere.personapi.dto.PersonDTO;
import ead.dio.bootcamp.codeanywhere.personapi.entity.Person;
import ead.dio.bootcamp.codeanywhere.personapi.messages.PersonMessageResponse;
import ead.dio.bootcamp.codeanywhere.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static ead.dio.bootcamp.codeanywhere.personapi.utils.PersonUtils.createFakeDTO;
import static ead.dio.bootcamp.codeanywhere.personapi.utils.PersonUtils.createFakeEntity;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSendMessage(){
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        Mockito.when(personRepository.save(expectedSavedPerson)).thenReturn(expectedSavedPerson);

        PersonMessageResponse expectedSucessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        PersonMessageResponse sucesaMessage = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSucessMessage, sucesaMessage);
        //assert. equals(expectedSucessMessage, sucesaMessage);
    }

    private PersonMessageResponse createExpectedMessageResponse(Long id) {
        return PersonMessageResponse.builder().message("Created person with id " + id).build();
    }
}
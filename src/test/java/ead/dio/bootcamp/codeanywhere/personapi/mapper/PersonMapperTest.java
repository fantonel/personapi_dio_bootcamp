package ead.dio.bootcamp.codeanywhere.personapi.mapper;

import ead.dio.bootcamp.codeanywhere.personapi.dto.PersonDTO;
import ead.dio.bootcamp.codeanywhere.personapi.dto.PhoneDTO;
import ead.dio.bootcamp.codeanywhere.personapi.entity.Person;
import ead.dio.bootcamp.codeanywhere.personapi.entity.Phone;
import ead.dio.bootcamp.codeanywhere.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonMapperTest {
    @Autowired
    private PersonMapper personMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person person = personMapper.toModel(personDTO);

        assertEquals(personDTO.getFirstName(), person.getFirstName());
        assertEquals(personDTO.getLastName(), person.getLastName());
        assertEquals(personDTO.getCpf(), person.getCpf());

        Phone phone = person.getPhones().get(0);
        PhoneDTO phoneDTO = personDTO.getPhones().get(0);

        assertEquals(phoneDTO.getPhoneType(), phone.getPhoneType());
        assertEquals(phoneDTO.getPrefix()+phoneDTO.getSuffix(), phone.getPrefix()+phone.getSuffix());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        Person person = PersonUtils.createFakeEntity();
        PersonDTO personDTO = personMapper.toDTO(person);

        assertEquals(person.getFirstName(), personDTO.getFirstName());
        assertEquals(person.getLastName(), personDTO.getLastName());
        assertEquals(person.getCpf(), personDTO.getCpf());

        Phone phone = person.getPhones().get(0);
        PhoneDTO phoneDTO = personDTO.getPhones().get(0);

        assertEquals(phone.getPhoneType(), phoneDTO.getPhoneType());
        assertEquals(phone.getPrefix()+phone.getSuffix(), phoneDTO.getPrefix()+phoneDTO.getSuffix());
    }
}
package ead.dio.bootcamp.codeanywhere.personapi.utils;

import ead.dio.bootcamp.codeanywhere.personapi.dto.PersonDTO;
import ead.dio.bootcamp.codeanywhere.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    private static final long   PERSON_ID  = 1L;
    private static final String FIRST_NAME = "FÁBIO";
    private static final String LAST_NAME  = "ANTONELLI";
    private static final String CPF_NUMBER = "11743225008";
    private static final LocalDate BIRTH_DATE = LocalDate.of(1982, 02, 10);

    public static PersonDTO createFakeDTO(){
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER).birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO())).build();
    }

    public static Person createFakeEntity(){
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity())).build();
    }
}
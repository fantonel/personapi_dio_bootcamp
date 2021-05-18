package ead.dio.bootcamp.codeanywhere.personapi.mapper;

import ead.dio.bootcamp.codeanywhere.personapi.dto.PersonDTO;
import ead.dio.bootcamp.codeanywhere.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings({@Mapping(source = "birthDate", target = "birthDate", dateFormat = "dd-MM-yyyy")})
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
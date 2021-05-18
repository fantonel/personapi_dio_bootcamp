package ead.dio.bootcamp.codeanywhere.personapi.dto;

import ead.dio.bootcamp.codeanywhere.personapi.entity.Person;
import ead.dio.bootcamp.codeanywhere.personapi.enums.PhoneOperator;
import ead.dio.bootcamp.codeanywhere.personapi.enums.PhoneType;
import ead.dio.bootcamp.codeanywhere.personapi.enums.PhoneUsage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {
    private Long id;
    @NotEmpty
    @Size(min = 2, max = 2)
    private String ddi;    //Código Internacional do País. Ex: Brasil = 55
    @Size(min = 2, max = 2)
    private String ddd;    //Código da região (Ex:14, 17, 47)
    @Size(min = 4, max = 5)
    private String prefix;
    @Size(min = 4, max = 5)
    private String suffix;

    @Enumerated(EnumType.ORDINAL)
    private PhoneType phoneType;
    @Enumerated(EnumType.ORDINAL)
    private PhoneUsage phoneUsage;
    @Enumerated(EnumType.ORDINAL)
    private PhoneOperator phoneOperator;

    private Person person;
}
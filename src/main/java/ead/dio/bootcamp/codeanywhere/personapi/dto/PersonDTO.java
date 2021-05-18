package ead.dio.bootcamp.codeanywhere.personapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private Long id;

    @NotEmpty
    @CPF
    private String cpf;
    @NotEmpty
    @Size(min = 2, max = 60)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;
    @NotEmpty
    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;
}
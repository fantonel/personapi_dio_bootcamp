package ead.dio.bootcamp.codeanywhere.personapi.messages;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonMessageResponse {
    private String message;
}
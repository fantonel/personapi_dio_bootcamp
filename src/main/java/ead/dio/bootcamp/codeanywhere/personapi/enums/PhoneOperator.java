package ead.dio.bootcamp.codeanywhere.personapi.enums;

import lombok.Getter;

@Getter
public enum PhoneOperator {
    VIVO(1),CLARO(2),TIM(3),OI(4),OTHERS(99);

    private final int phoneOperator = 1;

    PhoneOperator(int phoneOperator) {
    }
}
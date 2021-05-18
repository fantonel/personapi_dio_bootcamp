package ead.dio.bootcamp.codeanywhere.personapi.enums;

import lombok.Getter;

@Getter
public enum PhoneType {
    HOME(1), MOBILE(2), COMMERCIAL(3), MESSAGE(4);

    private final int phoneType = 1;

    PhoneType(int phoneType){
    }
}
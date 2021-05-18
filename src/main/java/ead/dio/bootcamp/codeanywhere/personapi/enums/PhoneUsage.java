package ead.dio.bootcamp.codeanywhere.personapi.enums;

import lombok.Getter;

@Getter
public enum PhoneUsage {
    WHATSAPP(1), TELEGRAM(2), MESSENGER(3);

    private final int phoneUsage = 1;

    PhoneUsage(int phoneUsage){
    }
}
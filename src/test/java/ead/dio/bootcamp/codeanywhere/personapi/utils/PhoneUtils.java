package ead.dio.bootcamp.codeanywhere.personapi.utils;

import ead.dio.bootcamp.codeanywhere.personapi.dto.PhoneDTO;
import ead.dio.bootcamp.codeanywhere.personapi.entity.Phone;
import ead.dio.bootcamp.codeanywhere.personapi.enums.PhoneOperator;
import ead.dio.bootcamp.codeanywhere.personapi.enums.PhoneType;
import ead.dio.bootcamp.codeanywhere.personapi.enums.PhoneUsage;

public class PhoneUtils {
    private static final Long PHONE_ID = 1L;
    private static final String DDI = "55";
    private static final String DDD = "17";
    private static final String PREFIX = "3547";
    private static final String SUFFIX = "1234";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final PhoneUsage PHONE_USAGE = PhoneUsage.WHATSAPP;
    private static final PhoneOperator PHONE_OPERATOR = PhoneOperator.VIVO;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .ddi(DDI)
                .ddd(DDD)
                .prefix(PREFIX)
                .suffix(SUFFIX)
                .phoneType(PHONE_TYPE)
                .phoneUsage(PHONE_USAGE)
                .phoneOperator(PHONE_OPERATOR)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .ddi(DDI)
                .ddd(DDD)
                .prefix(PREFIX)
                .suffix(SUFFIX)
                .phoneType(PHONE_TYPE)
                .phoneUsage(PHONE_USAGE)
                .phoneOperator(PHONE_OPERATOR)
                .build();
    }
}


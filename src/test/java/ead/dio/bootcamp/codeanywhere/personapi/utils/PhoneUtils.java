package ead.dio.bootcamp.codeanywhere.personapi.utils;

import ead.dio.bootcamp.codeanywhere.personapi.dto.PhoneDTO;
import ead.dio.bootcamp.codeanywhere.personapi.entity.Phone;
import ead.dio.bootcamp.codeanywhere.personapi.enums.PhoneOperator;
import ead.dio.bootcamp.codeanywhere.personapi.enums.PhoneType;
import ead.dio.bootcamp.codeanywhere.personapi.enums.PhoneUsage;

public class PhoneUtils {
    private static final long PHONE_ID = 1L;

    private static String DDI = "55";
    private static String DDD = "17";
    private static String PREFIX = "3547";
    private static String SUFIXX = "2244";
    private static final PhoneType  PHONE_TYPE  = PhoneType.COMMERCIAL;
    private static final PhoneUsage PHONE_USAGE = PhoneUsage.WHATSAPP;
    private static final PhoneOperator PHONE_OPERATOR = PhoneOperator.CLARO;

    public static PhoneDTO createFakeDTO(){
        return PhoneDTO.builder()
                .ddi(DDI)
                .ddd(DDD)
                .prefix(PREFIX)
                .suffix(SUFIXX)
                .phoneType(PHONE_TYPE)
                .phoneUsage(PHONE_USAGE)
                .phoneOperator(PHONE_OPERATOR)
                .build();
    }

    public static Phone createFakeEntity(){
        return Phone.builder()
                .id(PHONE_ID)
                .ddi(DDI)
                .ddd(DDD)
                .prefix(PREFIX)
                .suffix(SUFIXX)
                .phoneType(PHONE_TYPE)
                .phoneUsage(PHONE_USAGE)
                .phoneOperator(PHONE_OPERATOR)
                .build();
    }

}

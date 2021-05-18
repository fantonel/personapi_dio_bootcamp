package ead.dio.bootcamp.codeanywhere.personapi.entity;

import ead.dio.bootcamp.codeanywhere.personapi.enums.PhoneOperator;
import ead.dio.bootcamp.codeanywhere.personapi.enums.PhoneType;
import ead.dio.bootcamp.codeanywhere.personapi.enums.PhoneUsage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "dio", name = "phone")
public class Phone {
    @Id
    @SequenceGenerator(name = "phone_seq", sequenceName = "phone_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_seq")
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, length = 2)
    private String ddi;
    @Column(nullable = false, length = 2)
    private String ddd;
    @Column(nullable = false, length = 5)
    private String prefix;
    @Column(nullable = false, length = 6)
    private String suffix;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "phonetype_id", nullable = false)
    private PhoneType phoneType;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "phoneusage_id", nullable = false)
    private PhoneUsage phoneUsage;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "phoneoperator_id", nullable = false)
    private PhoneOperator phoneOperator;

}
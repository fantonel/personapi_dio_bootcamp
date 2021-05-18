package ead.dio.bootcamp.codeanywhere.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "dio", name = "person")
public class Person {
    @Id
    @SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    private Long id;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(name = "firstname", nullable = false, length = 30)
    private String firstName;
    @Column(name = "lastname", nullable = false, length = 60)
    private String lastName;
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthDate;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private List<Phone> phones;
}
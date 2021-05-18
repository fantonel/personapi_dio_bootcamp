package ead.dio.bootcamp.codeanywhere.personapi.repository;

import ead.dio.bootcamp.codeanywhere.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByCpf(String cpf);
}
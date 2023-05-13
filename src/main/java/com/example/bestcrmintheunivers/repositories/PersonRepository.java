package com.example.bestcrmintheunivers.repositories;

import com.example.bestcrmintheunivers.entities.Client;
import com.example.bestcrmintheunivers.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAllByClient(Client client);
}

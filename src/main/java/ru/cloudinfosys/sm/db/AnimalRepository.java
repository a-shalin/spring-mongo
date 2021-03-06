package ru.cloudinfosys.sm.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.cloudinfosys.sm.domain.Animal;

public interface AnimalRepository extends MongoRepository<Animal, String> {
    Animal findByName(String name);
}

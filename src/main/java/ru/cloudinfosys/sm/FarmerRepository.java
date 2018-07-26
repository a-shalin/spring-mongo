package ru.cloudinfosys.sm;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.cloudinfosys.sm.domain.Farmer;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "farmers", path = "farmers")
public interface FarmerRepository extends MongoRepository<Farmer, String> {
    List<Farmer> findByFirstNameContainingOrLastNameContaining(@Param("name") String firstName,
                                                               @Param("lastName") String lastName);
    List<Farmer> findByFirstNameContains(@Param("name") String name);
    List<Farmer> findByFirstName(@Param("name") String name);
}

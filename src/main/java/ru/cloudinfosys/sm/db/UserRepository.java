package ru.cloudinfosys.sm.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.cloudinfosys.sm.domain.User;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "farmers", path = "farmers")
public interface UserRepository extends MongoRepository<User, String> {
    User findByLogin(String login);
    List<User> findByFirstNameContainingOrLastNameContaining(@Param("name") String firstName,
                                                             @Param("lastName") String lastName);
    List<User> findByFirstNameContains(@Param("name") String name);
    List<User> findByFirstName(@Param("name") String name);

    @Query("{$text: {$search : ?0}}")
    List<User> findByName(String name);
}

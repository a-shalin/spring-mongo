package ru.cloudinfosys.sm.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.cloudinfosys.sm.domain.User;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void findByFirstNameContainingOrLastNameContaining() {
        User user1 = new User();
        user1.setLogin("user1");
        user1.setFirstName("Testj9JhjsadjYpqlsmdFirstName");
        user1.setLastName("j9JhjsadjYpqlsmdLastName");
        user1.setEmail("user1@email.com");
        user1.setPassHash("user1hash");
        user1 = userRepository.insert(user1);

        User user2 = new User();
        user1.setLogin("user2");
        user1.setFirstName("FirstNamej9JhjsadjYpqlsmd");
        user1.setLastName("LastNameTestj9JhjsadjYpqlsmd");
        user1.setEmail("user2@email.com");
        user1.setPassHash("user2hash");
        user2 = userRepository.insert(user2);

        try {
            List<User> users = userRepository
                    .findByFirstNameContainingOrLastNameContaining("Testj9JhjsadjYpqlsmd", "Testj9JhjsadjYpqlsmd");
            assertEquals(2, users.size());
        } finally {
            userRepository.delete(user1);
            userRepository.delete(user2);
        }
    }

    @Test
    public void findFullText() {
        List<User> users;
        users = userRepository.findByName("Andrey");
        assertEquals(1, users.size());

        users = userRepository.findByName("Shalin");
        assertEquals(3, users.size());
    }
}
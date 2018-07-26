package ru.cloudinfosys.sm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.cloudinfosys.sm.domain.Farmer;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FarmerRepositoryTest {
    @Autowired
    FarmerRepository farmerRepository;

    @Test
    public void findByFirstNameContainingOrLastNameContaining() {
        Farmer farmer1 = farmerRepository.insert(new Farmer("Testj9JhjsadjYpqlsmdFirstName", "j9JhjsadjYpqlsmdLastName"));
        Farmer farmer2 = farmerRepository.insert(new Farmer("FirstNamej9JhjsadjYpqlsmd", "LastNameTestj9JhjsadjYpqlsmd"));

        try {
            List<Farmer> farmers = farmerRepository
                    .findByFirstNameContainingOrLastNameContaining("Testj9JhjsadjYpqlsmd", "Testj9JhjsadjYpqlsmd");
            assertEquals(2, farmers.size());
        } finally {
            farmerRepository.delete(farmer1);
            farmerRepository.delete(farmer2);
        }
    }
}
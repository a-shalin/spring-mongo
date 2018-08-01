package ru.cloudinfosys.sm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.cloudinfosys.sm.db.AnimalRepository;
import ru.cloudinfosys.sm.db.MarketRepository;
import ru.cloudinfosys.sm.db.UserRepository;
import ru.cloudinfosys.sm.domain.Animal;
import ru.cloudinfosys.sm.domain.AnimalPart;
import ru.cloudinfosys.sm.domain.Market;
import ru.cloudinfosys.sm.domain.User;

import javax.annotation.PostConstruct;

import static java.util.Arrays.asList;

@SpringBootApplication
public class SpringMongoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}

	@Autowired
    UserRepository userRepository;
    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    MarketRepository marketRepository;
    @Autowired
    App app;

	@PostConstruct
	public void initData() {
	    userRepository.deleteAll();

        String[][] users = {
                {"Andrey", "Shalin"},
                {"Arseniy", "Shalin"},
                {"Mitrofan", "Shalin"}
        };

        for (String[] userData : users) {
            User user = new User();
            user.setFirstName(userData[0]);
            user.setLastName(userData[1]);
            user.setLogin((userData[0]+"."+userData[1]).toLowerCase());
            userRepository.insert(user);
        }

        animalRepository.deleteAll();

        animalRepository.insert(asList(
            new Animal("Cow", 100.0, asList(
                    new AnimalPart("Front leg", 2, 8.20),
                    new AnimalPart("Back leg", 2, 11.33),
                    new AnimalPart("Neck", 1, 5.55)
            )),
            new Animal("Pig", 40.0, asList(
                    new AnimalPart("Front leg", 2, 4.12),
                    new AnimalPart("Back leg", 2, 5.87),
                    new AnimalPart("Neck", 1, 3.44)
            ))
        ));

        marketRepository.deleteAll();

        Market market;

        market = new Market();
        market.setFarmer(userRepository.findByLogin("andrey.shalin"));
        market.setAnimalPart(animalRepository.findByName("Cow").getParts().get(0));
        market.setWeight(7.11);
        market.setPrice(311.12);
        market.setWeightError(0.0);

        marketRepository.insert(market);
    }
}

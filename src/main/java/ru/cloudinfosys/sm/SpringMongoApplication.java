package ru.cloudinfosys.sm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.cloudinfosys.sm.domain.Animal;
import ru.cloudinfosys.sm.domain.AnimalPart;
import ru.cloudinfosys.sm.domain.Farmer;
import ru.cloudinfosys.sm.domain.Market;

import javax.annotation.PostConstruct;

import java.util.List;

import static java.util.Arrays.asList;

@SpringBootApplication
public class SpringMongoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}

	@Autowired
    FarmerRepository farmerRepository;
    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    MarketRepository marketRepository;

	@PostConstruct
	public void initData() {
	    farmerRepository.deleteAll();

        List<Farmer> farmers = farmerRepository.insert(asList(
            new Farmer("Andrey", "Shalin"),
            new Farmer("Arseniy", "Shalin"),
            new Farmer("Mitrofan", "Shalin")
        ));

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
        market.setFarmer(farmers.get(0));
        market.setAnimalPart(animalRepository.findByName("Cow").getParts().get(0));
        market.setWeight(7.11);
        market.setPrice(311.12);
        market.setWeightError(0.0);

        marketRepository.insert(market);
    }
}

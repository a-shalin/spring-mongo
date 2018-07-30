package ru.cloudinfosys.sm.domain;

import org.springframework.data.annotation.Id;

public class Market {
    @Id
    private String id;
    private Farmer farmer;
    private AnimalPart animalPart;
    private double weight;
    private double weightError;
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public AnimalPart getAnimalPart() {
        return animalPart;
    }

    public void setAnimalPart(AnimalPart animalPart) {
        this.animalPart = animalPart;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeightError() {
        return weightError;
    }

    public void setWeightError(double weightError) {
        this.weightError = weightError;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

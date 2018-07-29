package ru.cloudinfosys.sm.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Animal {
    @Id
    private String id;
    private String name;
    private double typicalWeight;
    private List<AnimalPart> parts;

    public Animal() {}
    public Animal(String name, double typicalWeight, List<AnimalPart> parts) {
        this.name = name;
        this.typicalWeight = typicalWeight;
        this.parts = parts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTypicalWeight() {
        return typicalWeight;
    }

    public void setTypicalWeight(double typicalWeight) {
        this.typicalWeight = typicalWeight;
    }

    public List<AnimalPart> getParts() {
        return parts;
    }

    public void setParts(List<AnimalPart> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", typicalWeight=" + typicalWeight +
                ", parts=" + parts +
                '}';
    }
}

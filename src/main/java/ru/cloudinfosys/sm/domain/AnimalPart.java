package ru.cloudinfosys.sm.domain;

import org.springframework.data.annotation.Id;

public class AnimalPart {
    @Id
    private String id;
    private String name;
    private int quantity;
    private double typicalWeight;

    public AnimalPart() {}
    public AnimalPart(String name, int quantity, double typicalWeight) {
        this.name = name;
        this.quantity = quantity;
        this.typicalWeight = typicalWeight;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTypicalWeight() {
        return typicalWeight;
    }

    public void setTypicalWeight(double typicalWeight) {
        this.typicalWeight = typicalWeight;
    }

    @Override
    public String toString() {
        return "AnimalPart{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", typicalWeight=" + typicalWeight +
                '}';
    }
}

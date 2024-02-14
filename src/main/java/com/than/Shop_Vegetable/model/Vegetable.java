package com.than.Shop_Vegetable.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Vegetable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_vegetable")
    private String nameVegetable;
    private int counts;
    private String years;
    private String prices;
    
    public Vegetable() {
    }

    public Vegetable(String nameVegetable, int counts, String years, String prices) {
        this.nameVegetable = nameVegetable;
        this.counts = counts;
        this.years = years;
        this.prices = prices;
    }

}

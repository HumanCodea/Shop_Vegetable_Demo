package com.than.Shop_Vegetable.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MyVegetable {

    @Id
    private int id;
    @Column(name = "name_vegetable")
    private String nameVegetable;
    private int counts;
    private String years;
    private String prices;
    
    public MyVegetable() {
    }

    public MyVegetable(int id,String nameVegetable, int counts, String years, String prices) {
        this.id = id;
        this.nameVegetable = nameVegetable;
        this.counts = counts;
        this.years = years;
        this.prices = prices;
    }

}

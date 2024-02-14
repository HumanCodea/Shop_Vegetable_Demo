package com.than.Shop_Vegetable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.than.Shop_Vegetable.model.MyVegetable;

@Repository
public interface MyVegetableRepository extends JpaRepository<MyVegetable, Integer>{
    
    @Query("Select v From MyVegetable v Where v.nameVegetable Like %?1%")
    public List<MyVegetable> findByNameMyVegetable(String nameVegetable);
}

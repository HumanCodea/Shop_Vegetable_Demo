package com.than.Shop_Vegetable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.than.Shop_Vegetable.model.Vegetable;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Integer>{
    
    @Query("Select v From Vegetable v Where v.nameVegetable Like %?1%")
    public List<Vegetable> findByNameVegetable(String nameVegetable);
}

package com.than.Shop_Vegetable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.than.Shop_Vegetable.model.Vegetable;
import com.than.Shop_Vegetable.repository.VegetableRepository;

@Service
public class VegetableService {

    @Autowired
    private VegetableRepository vegetableRepository;

    public List<Vegetable> getAll(){
        return vegetableRepository.findAll();
    }

    public void SaveVegetable(Vegetable  vegetable){
        vegetableRepository.save(vegetable);
    }

    public void DeleteVegetable(int id){
        vegetableRepository.deleteById(id);
    }

    public Vegetable FindById(int id){
        return vegetableRepository.findById(id).get();
    }

    public List<Vegetable> findByNameVegetable(String nameVegetable){
        return vegetableRepository.findByNameVegetable(nameVegetable);
    }
    
}

package com.than.Shop_Vegetable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.than.Shop_Vegetable.model.MyVegetable;
import com.than.Shop_Vegetable.repository.MyVegetableRepository;

@Service
public class MyVegetableService {

    @Autowired
    private MyVegetableRepository myVegetableRepository;
    
    public List<MyVegetable> getAllMyVegetables(){
        return myVegetableRepository.findAll();
    }

    public void DeleteMyVetable(int id){
        myVegetableRepository.deleteById(id);
    }

    public void SaveMyVegetable(MyVegetable myVegetable){
        myVegetableRepository.save(myVegetable);
    }

     public List<MyVegetable> findByNameMyVegetable(String nameVegetable){
        return myVegetableRepository.findByNameMyVegetable(nameVegetable);
    }

}

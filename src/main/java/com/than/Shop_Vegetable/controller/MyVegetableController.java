package com.than.Shop_Vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.than.Shop_Vegetable.model.MyVegetable;
import com.than.Shop_Vegetable.service.MyVegetableService;

@Controller
@RequestMapping(path = "")
public class MyVegetableController {

    @Autowired
    private MyVegetableService myVegetableService;

    @GetMapping("/my_vegetable")
    public String MyVegetable(Model model, @Param("nameVegetable") String nameVegetable){
        List<MyVegetable> list = myVegetableService.getAllMyVegetables();
        if(nameVegetable != null){
            list = myVegetableService.findByNameMyVegetable(nameVegetable);
            model.addAttribute("nameVegetable", nameVegetable);
        }
        model.addAttribute("vegetable", list);
        return "myVegetable";
    }

    @GetMapping("/deleteMyList/{id}")
    public String DeleteMyVegetable(@PathVariable("id") int id){
        myVegetableService.DeleteMyVetable(id);
        return "redirect:/my_vegetable";
    }
}

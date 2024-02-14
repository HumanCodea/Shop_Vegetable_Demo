package com.than.Shop_Vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.than.Shop_Vegetable.model.MyVegetable;
import com.than.Shop_Vegetable.model.Vegetable;
import com.than.Shop_Vegetable.service.MyVegetableService;
import com.than.Shop_Vegetable.service.VegetableService;



@Controller
@RequestMapping(path = "")
public class VegetableController {

    @Autowired
    private VegetableService vegetableService;

    @Autowired
    private MyVegetableService myVegetableService;

    @GetMapping("/home")
    public String HomeUser(){
        return "homeUser";
    }

    @GetMapping("homeAdmin")
    public String HomeAdmin(){
        return "homeAdmin";
    }

    @PostMapping("/save")
    public String Save(@ModelAttribute Vegetable vegetable){
        vegetableService.SaveVegetable(vegetable);
        return "redirect:/available_vegetable";
    }

    @GetMapping("/available_vegetable")
    public String ListVegetable(Model model, @Param("nameVegetable") String nameVegetable){
        List<Vegetable> list = vegetableService.getAll();
        if (nameVegetable != null) {
            list = vegetableService.findByNameVegetable(nameVegetable);
            model.addAttribute("nameVegetable", nameVegetable);
        }
        model.addAttribute("vegetable", list);
        return "listVegetable";
    }

    @GetMapping("/vegetable_register")
    public String VegetableRegister(){
        return "registerVegetable";
    }

    @GetMapping("/deleteList/{id}")
    public String DeleteVegetable(@PathVariable("id") int id){
        vegetableService.DeleteVegetable(id);
        return "redirect:/available_vegetable";
    }

    @GetMapping("/editList/{id}")
    public String EditVegetable(@PathVariable("id") int id, Model model){
        Vegetable vegetable = vegetableService.FindById(id);
        model.addAttribute("vegetable", vegetable);
        return "editVegetable";
    }

    @GetMapping("/mylist/{id}")
    public String AddToMyVegetable(@PathVariable("id") int id){
        Vegetable vegetable = vegetableService.FindById(id);
        MyVegetable myVegetable = new MyVegetable(vegetable.getId(), vegetable.getNameVegetable(), vegetable.getCounts(), vegetable.getYears(), vegetable.getPrices());
        myVegetableService.SaveMyVegetable(myVegetable);
        return "redirect:/my_vegetable";
    }

    @GetMapping("/search_vegetable")
    public String SearchVegetable(Model model, @Param("nameVegetable") String nameVegetable){
        List<Vegetable> list = vegetableService.getAll();
        if (nameVegetable != null) {
            list = vegetableService.findByNameVegetable(nameVegetable);
            model.addAttribute("nameVegetable", nameVegetable);
        }
        model.addAttribute("vegetable", list);
        return "searchVegetable";
    }


}

package com.example.StudentManagement.controller;

import com.example.StudentManagement.model.Laptop;
import com.example.StudentManagement.service.LaptopService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("laptop")
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @PostMapping()
    public String addLaptop(@RequestBody Laptop laptop){

        return laptopService.addLaptop(laptop);
    }

    @GetMapping()
    public List<Laptop> getAllLaptop(@Nullable @RequestParam Long laptopId){
        return laptopService.getAllLaptop(laptopId);
    }

    @DeleteMapping("/{laptopId}")
    public String deleteLaptopById(@PathVariable Long laptopId){
        return laptopService.deleteLaptopById(laptopId);
    }

    @PutMapping("/{LaptopId}")
    public String updateLaptop(@PathVariable Long LaptopId , @RequestBody Laptop laptop){
        return laptopService.updateLaptop(LaptopId , laptop);
    }

}

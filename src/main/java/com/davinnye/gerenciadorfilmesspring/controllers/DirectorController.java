package com.davinnye.gerenciadorfilmesspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.davinnye.gerenciadorfilmesspring.dtos.DirectorDto;
import com.davinnye.gerenciadorfilmesspring.services.DirectorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class DirectorController {
    
    @Autowired
    private DirectorService ds;

    @PostMapping("/directors") 
    public boolean addDirector(@RequestBody DirectorDto director) {
        return this.ds.addDirector(director);
    }

    @GetMapping("/directors")    
    public List<DirectorDto> directorsList(){
        return this.ds.directorsList();
    }
}

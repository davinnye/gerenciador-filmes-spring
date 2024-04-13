package com.davinnye.gerenciadorfilmesspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.davinnye.gerenciadorfilmesspring.dtos.ActorDto;
import com.davinnye.gerenciadorfilmesspring.services.ActorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ActorController {
    @Autowired
    private ActorService as;

    @PostMapping("/actors")
    public boolean addActor(@RequestBody ActorDto actor) {
        return this.as.addActor(actor);
    }

    @GetMapping("/actors")
    public List<ActorDto> actorsList() {
        return this.as.actorsList();
    }
    
    
}

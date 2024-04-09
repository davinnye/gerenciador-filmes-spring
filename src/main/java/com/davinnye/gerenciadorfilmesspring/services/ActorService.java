package com.davinnye.gerenciadorfilmesspring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davinnye.gerenciadorfilmesspring.dtos.ActorDto;
import com.davinnye.gerenciadorfilmesspring.entitites.Actor;
import com.davinnye.gerenciadorfilmesspring.repositories.ActorRepository;



@Service
public class ActorService {

    @Autowired
    private ActorRepository ar;

    //para falar que vai mexer no banco de dados, tem que ser do spring para pegar o RO
    @Transactional(readOnly = false)
    public boolean addActor(ActorDto actor){
        Actor newActor = new Actor(actor);

        Actor actorSaved = this.ar.save(newActor);

        if (actorSaved != null){
            return true;
        }
        else {
            return false;
        }
    }

    @Transactional(readOnly = true)
    public List<ActorDto> actorsList(){
            List<Actor> savedActors = ar.findByOrderByNameAsc();
            List<ActorDto> actors = null;
            
            if(savedActors != null){
                actors = new ArrayList<ActorDto>(null);

                for(Actor a : savedActors){
                    actors.add(new ActorDto(a));
                }

            }
            
            return actors;
    }
    

}

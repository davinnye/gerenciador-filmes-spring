package com.davinnye.gerenciadorfilmesspring.services;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davinnye.gerenciadorfilmesspring.dtos.ActorDto;
import com.davinnye.gerenciadorfilmesspring.dtos.MovieDto;
import com.davinnye.gerenciadorfilmesspring.entitites.Actor;
import com.davinnye.gerenciadorfilmesspring.entitites.Director;
import com.davinnye.gerenciadorfilmesspring.entitites.Movie;
import com.davinnye.gerenciadorfilmesspring.repositories.ActorRepository;
import com.davinnye.gerenciadorfilmesspring.repositories.DirectorRepository;
import com.davinnye.gerenciadorfilmesspring.repositories.MovieRepository;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository mr;
    @Autowired
    private ActorRepository ar;
    @Autowired
    private DirectorRepository dr;

    @Transactional(readOnly = false)
    public boolean addMovie(MovieDto movie){
        Director existingDirector = dr.getReferenceByName(movie.getDirector().getName());
        
        HashSet<Actor> cast = new HashSet<Actor>();

        for (ActorDto a : movie.getCast()){
            Actor existingActor = ar.getReferenceByName(a.getName());

            if (existingActor != null)
                cast.add(existingActor);
            else
                cast.add(new Actor(a));
        }

        Movie m;

        if (existingDirector != null)
            m = new Movie(movie.getName(), existingDirector, cast, movie.getReception());


        else

            m = new Movie(movie.getName(), new Director(movie.getDirector()), cast, movie.getReception());
        }

        Movie 


}

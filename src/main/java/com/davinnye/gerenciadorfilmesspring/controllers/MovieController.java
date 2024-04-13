package com.davinnye.gerenciadorfilmesspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.davinnye.gerenciadorfilmesspring.dtos.ActorDto;
import com.davinnye.gerenciadorfilmesspring.dtos.DirectorDto;
import com.davinnye.gerenciadorfilmesspring.dtos.MovieDto;
import com.davinnye.gerenciadorfilmesspring.services.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class MovieController {
    @Autowired
    private MovieService ms;

    @PostMapping("/movies")
    public boolean addMovie(@RequestBody MovieDto movie) {
        return this.ms.addMovie(movie);
    }
    
    @GetMapping("/movies")
    public List<MovieDto> moviesList () {
        return this.ms.listMoviesOrderedByName();
    }
    
    @GetMapping("/movies/director/{directorname}")
    public List<MovieDto> moviesListByDirector (@PathVariable("directorname") String directorName) {
        DirectorDto director = new DirectorDto(directorName);
        return this.ms.listMoviesByDirector(director);
    }

    @GetMapping("/movies/actor/{actorname}")
    public List<MovieDto> moviesListByActor (@PathVariable("actorname") String actorName) {
        ActorDto actor = new ActorDto(actorName);
        return this.ms.listMoviesByActor(actor);
    }

    @GetMapping("/movies/reception/{reception}")
    public List<MovieDto> moviesListByReception (@PathVariable("reception") Float reception) {
        return this.ms.listMoviesByReception(reception);
    }

}

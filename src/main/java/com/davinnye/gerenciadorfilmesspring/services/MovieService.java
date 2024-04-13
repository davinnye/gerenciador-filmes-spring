package com.davinnye.gerenciadorfilmesspring.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davinnye.gerenciadorfilmesspring.dtos.ActorDto;
import com.davinnye.gerenciadorfilmesspring.dtos.DirectorDto;
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
        

        Movie returnMovie = mr.save(m);

        if (returnMovie != null)
            return true;
        
        else

            return false;

    }



    @Transactional(readOnly = true)
    public List<MovieDto> listMoviesOrderedByName(){
        List<Movie> savedMovies = this.mr.findByOrderByNameAsc();

        List<MovieDto> moviesDto = convertMovieListToMovieDto(savedMovies);

        return moviesDto;
    } 

    @Transactional(readOnly = true)
    public List<MovieDto> listMoviesByDirector (DirectorDto director){
        Director savedDirector = dr.getReferenceByName(director.getName());

        if(savedDirector == null){
        return null;
    }

        List<Movie> savedMovies = mr.findByDirectorOrderByNameAsc(savedDirector);

        List<MovieDto> movieDtos = convertMovieListToMovieDto(savedMovies);
        
        return movieDtos;
    }

    @Transactional(readOnly = true)
    public List<MovieDto> listMoviesByActor(ActorDto actor){
        Actor a = this.ar.getReferenceByName(actor.getName());

        if(a==null)
            return null;
        
        List<Movie> savedMovies = mr.findByActorOrderByName(a.getId());

        List<MovieDto> movieDtos = convertMovieListToMovieDto(savedMovies);
            
        return movieDtos;
        
    }

    @Transactional(readOnly = true)
    public List<MovieDto> listMoviesByReception(Float reception){
        List<Movie> movies = mr.findByReceptionGreaterThanEqualOrderByName(reception);

        List<MovieDto> movieDtos = convertMovieListToMovieDto(movies);
        if (movies != null){
            movieDtos = new ArrayList<MovieDto>();

            for (Movie m : movies){
                movieDtos.add(new MovieDto(m));
            }
        }

        return movieDtos;

    }



    private List<MovieDto> convertMovieListToMovieDto(List<Movie> movies){
        List<MovieDto> movieDtos = null;

        if (movies != null){
            movieDtos = new ArrayList<MovieDto>();
            for (Movie m : movies)
                    movieDtos.add(new MovieDto(m));
        }

        return movieDtos;
    }

}





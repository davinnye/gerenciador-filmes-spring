package com.davinnye.gerenciadorfilmesspring.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.davinnye.gerenciadorfilmesspring.entitites.Actor;
import com.davinnye.gerenciadorfilmesspring.entitites.Movie;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDto implements Serializable{
    private static final long serialVersionUID = 1L;

    @JsonProperty
    private String name;
    @JsonProperty
    private DirectorDto director;
    @JsonProperty
    private ActorDto actor;
    @JsonProperty
    private Set<ActorDto> cast;
    @JsonProperty
    private float reception;

    @JsonCreator
    public MovieDto(String name, DirectorDto director, Set<ActorDto> cast, float reception) {
        super();
        this.name = name;
        this.director = new DirectorDto(director);
        this.cast = new HashSet<ActorDto>(cast);
        this.reception = reception;
    }
    
    public MovieDto(MovieDto movie){
        this(movie.getName(), movie.getDirector(), movie.getCast(), movie.getReception());

    }

    public MovieDto(Movie movie){
        this.name = movie.getName();
        this.director = new DirectorDto(movie.getDirector());
        this.reception = movie.getReception();

        for(Actor a : movie.getCast()){
            this.cast.add(new ActorDto(a));
        }
    }

    public String getName() {
        return name;
    }

    public DirectorDto getDirector() {
        return director;
    }

    public ActorDto getActor() {
        return actor;
    }

    public Set<ActorDto> getCast() {
        return cast;
    }

    public float getReception() {
        return reception;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirector(DirectorDto director) {
        this.director = director;
    }

    public void setActor(ActorDto actor) {
        this.actor = actor;
    }

    public void setCast(Set<ActorDto> cast) {
        this.cast = cast;
    }

    public void setReception(float reception) {
        this.reception = reception;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((director == null) ? 0 : director.hashCode());
        result = prime * result + ((actor == null) ? 0 : actor.hashCode());
        result = prime * result + ((cast == null) ? 0 : cast.hashCode());
        result = prime * result + Float.floatToIntBits(reception);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MovieDto other = (MovieDto) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (director == null) {
            if (other.director != null)
                return false;
        } else if (!director.equals(other.director))
            return false;
        if (actor == null) {
            if (other.actor != null)
                return false;
        } else if (!actor.equals(other.actor))
            return false;
        if (cast == null) {
            if (other.cast != null)
                return false;
        } else if (!cast.equals(other.cast))
            return false;
        if (Float.floatToIntBits(reception) != Float.floatToIntBits(other.reception))
            return false;
        return true;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    


}

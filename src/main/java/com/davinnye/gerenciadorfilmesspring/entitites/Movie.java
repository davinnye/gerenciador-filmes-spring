package com.davinnye.gerenciadorfilmesspring.entitites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="cf_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String name;
    @ManyToOne
    private Director director;
    @ManyToMany
    private Set<Actor> cast;
    private Float reception;
    
    public Movie(){

    }

    public Movie(Long id, String name, Director director, Set<Actor> cast, Float reception){
        super();
        this.id = id;
        this.name = name;
        this.director = director;
        this.cast = cast;
        this.reception = reception;
    }

    public Movie(String name2, Director existingDirector, HashSet<Actor> cast2, float reception2) {
        //TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }
    public Set<Actor> getCast() {
        return cast;
    }
    public void setCast(Set<Actor> cast) {
        this.cast = cast;
    }
    public float getReception() {
        return reception;
    }
    public void setReception(float reception) {
        this.reception = reception;
    }

    

}

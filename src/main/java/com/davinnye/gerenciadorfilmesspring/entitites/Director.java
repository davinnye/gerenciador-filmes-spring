package com.davinnye.gerenciadorfilmesspring.entitites;

import com.davinnye.gerenciadorfilmesspring.dtos.DirectorDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "cf_diretor")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique=true)
    private String name;

    public Director (){
        
    }

    public Director(String name){
        //perguntar a ivan o pq desse super
        super();
        this.name = name;
    }

    public Director(Long id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    public Director(DirectorDto director) {
        this.name = director.getName();
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }



}

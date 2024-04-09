package com.davinnye.gerenciadorfilmesspring.entitites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="cf_actor")
public class Actor {
    //torna o campo único no db
    @Column(unique=true)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //fala pra aplicação gerar o ID seguindo regra de sequência
    private Long id;

    public Actor (){
    }

    public Actor (Long id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId (Long id){
        this.id = id;
    }


}

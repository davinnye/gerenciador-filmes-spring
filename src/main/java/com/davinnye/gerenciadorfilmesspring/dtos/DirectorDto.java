package com.davinnye.gerenciadorfilmesspring.dtos;

import java.io.Serializable;

import com.davinnye.gerenciadorfilmesspring.entitites.Director;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DirectorDto implements Serializable{
    private static final long serialVersionUID = 1L;

    @JsonProperty
    private String name;
    
    public DirectorDto(){
    }

    @JsonCreator
    public DirectorDto(String name){
        this.name = name;
    }

    public DirectorDto(DirectorDto director){
        this.name = director.getName();
    }

    public DirectorDto(Director director){
        this.name = director.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        DirectorDto other = (DirectorDto) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}

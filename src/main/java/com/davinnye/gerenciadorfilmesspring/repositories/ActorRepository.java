package com.davinnye.gerenciadorfilmesspring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davinnye.gerenciadorfilmesspring.entitites.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>{

    public List<Actor> findByOrderByNameAsc();

}

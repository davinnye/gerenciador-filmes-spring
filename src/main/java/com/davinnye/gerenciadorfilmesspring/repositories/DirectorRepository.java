package com.davinnye.gerenciadorfilmesspring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davinnye.gerenciadorfilmesspring.entitites.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>{
    public List<Director> findByOrderByNameAsc();
    public Director getReferenceByName(String name);
    
}

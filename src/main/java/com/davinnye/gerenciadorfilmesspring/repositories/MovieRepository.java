package com.davinnye.gerenciadorfilmesspring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.davinnye.gerenciadorfilmesspring.entitites.Director;
import com.davinnye.gerenciadorfilmesspring.entitites.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
    public List<Movie> findByOrderByNameAsc();
    public List<Movie> findByDirectorOrderByNameAsc(Director director);
    public List<Movie> findByReceptionGreaterThanEqualOrderByName(Float reception);
    @Query(value="select * from cf_movie as u inner join cf_movie_cast as e on e.movie_id=u.id WHERE cast_id=:id order by name", nativeQuery=true)
    public List<Movie> findByActorOrderByName(Long id);    

}

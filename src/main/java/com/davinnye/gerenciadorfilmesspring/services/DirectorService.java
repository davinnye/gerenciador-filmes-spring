package com.davinnye.gerenciadorfilmesspring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davinnye.gerenciadorfilmesspring.dtos.DirectorDto;
import com.davinnye.gerenciadorfilmesspring.entitites.Director;
import com.davinnye.gerenciadorfilmesspring.repositories.DirectorRepository;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository dr;

    @Transactional(readOnly = false)
    public boolean addDirector(DirectorDto director){
        Director newDirector = dr.save(new Director(director));

        if(newDirector != null)
            return true;
        else
            return false;
    }

    @Transactional(readOnly = true)
    public List<DirectorDto> directorsList(){
        
        List<Director> savedDirectors = this.dr.findByOrderByNameAsc();

        List<DirectorDto> directorsDto = null;

        if (savedDirectors != null){
            directorsDto = new ArrayList<DirectorDto>();

            for(Director d : savedDirectors)
                        directorsDto.add(new DirectorDto(d));
        }

        return directorsDto;
    }
    
}

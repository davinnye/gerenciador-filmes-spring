package com.davinnye.gerenciadorfilmesspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.davinnye.gerenciadorfilmesspring.repositories.ActorRepository;

@SpringBootApplication
public class GerenciadorFilmesSpringApplication {


	@Autowired
	private ActorRepository ar;
	public static void main(String[] args) {
		SpringApplication.run(GerenciadorFilmesSpringApplication.class, args);
	}

}

package com.henrique.boockstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.henrique.boockstore.domain.Categoria;
import com.henrique.boockstore.domain.Livro;
import com.henrique.boockstore.repository.CategoriaRepository;
import com.henrique.boockstore.repository.LivroRepository;

@SpringBootApplication
public class BoockstoreApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BoockstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informatica", "livros de ti");
		
		Livro l1 = new Livro(null, "Clean Code", "Robber M", "Loemdalskjdlkja", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}

}

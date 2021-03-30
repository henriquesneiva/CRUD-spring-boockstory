package com.henrique.boockstore.servise;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrique.boockstore.domain.Categoria;
import com.henrique.boockstore.domain.Livro;
import com.henrique.boockstore.repository.CategoriaRepository;
import com.henrique.boockstore.repository.LivroRepository;

@Service
public class DBServise {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "informatica", "livros de ti");
		Categoria cat2 = new Categoria(null, "ficao", "ti");
		Categoria cat3 = new Categoria(null, "programacao", "livros de ti");
		Categoria cat4 = new Categoria(null, "programacao", "livros");
		
		Livro l1 = new Livro(null, "Clean Code", "Robbert M", "LOren Ipslon hshs", cat1);
		Livro l2 = new Livro(null, " programacao limpa", "Robbert M", "LOren Ipslon hshs", cat3);
		Livro l3 = new Livro(null, "bla bla bla", "henrique M", "LOren Ipslon hshs", cat2);
		Livro l4 = new Livro(null, "arquitetura limpa", "Robbert M", "LOren Ipslon hshs", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l4));
		cat1.getLivros().addAll(Arrays.asList(l3));
		cat3.getLivros().addAll(Arrays.asList(l2));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4));
		
	}
	
}

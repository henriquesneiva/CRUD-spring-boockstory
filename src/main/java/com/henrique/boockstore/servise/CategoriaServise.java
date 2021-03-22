package com.henrique.boockstore.servise;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrique.boockstore.domain.Categoria;
import com.henrique.boockstore.repository.CategoriaRepository;
import com.henrique.boockstore.servise.exceptions.ObjectNotFoundException;

@Service
public class CategoriaServise {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {

		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrato! id = " + id + ", tipo:" + Categoria.class.getName()));

	}

}

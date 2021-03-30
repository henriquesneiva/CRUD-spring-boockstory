package com.henrique.boockstore.servise;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrique.boockstore.domain.Categoria;
import com.henrique.boockstore.domain.Livro;
import com.henrique.boockstore.repository.LivroRepository;
import com.henrique.boockstore.servise.exceptions.ObjectNotFoundException;

@Service
public class LivroServise {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private CategoriaServise categoriaServise;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Livro nao encontrado id: " + id + ", tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {

		categoriaServise.findById(id_cat);
		return repository.findAllByCategoria(id_cat);

	}

	public Livro update(Integer id, Livro obj) {

		Livro newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		
		newObj.setTitulo(obj.getTitulo());
		newObj.setCategoria(obj.getCategoria());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
	}

	public Livro create(Integer id_cat, Livro obj) {

		obj.setId(null);
		Categoria cat = categoriaServise.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		
		Livro obj = findById(id);
		repository.delete(obj);
		
	}

}

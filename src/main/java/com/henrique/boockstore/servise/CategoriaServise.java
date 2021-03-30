package com.henrique.boockstore.servise;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.henrique.boockstore.domain.Categoria;
import com.henrique.boockstore.dto.CategoriaDTO;
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

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDTO) {

		Categoria obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		return repository.save(obj);

	}

	public void delite(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.henrique.boockstore.servise.exceptions.DataIntegrityViolationException(
					"essa categoria nao pode ser deletado : possui livros associados");
		}
	}

}

package com.henrique.boockstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.henrique.boockstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

	@Query("SELECT obj FROM Livro obj WhERE obj.categoria.id = :id_cat ORDER BY titulo"
			+ "")
	List<Livro> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);

}

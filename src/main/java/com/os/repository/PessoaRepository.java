package com.os.repository;

import com.os.domain.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	@Query("select obj from Pessoa obj where obj.cpf =:cpf")
	Pessoa findByCPF(@Param("cpf") String cpf);
}

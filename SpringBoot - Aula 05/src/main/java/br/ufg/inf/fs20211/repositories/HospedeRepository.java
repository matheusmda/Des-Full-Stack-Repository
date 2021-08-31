package br.ufg.inf.fs20211.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufg.inf.fs20211.entities.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Integer>{
	
	@Query("SELECT h FROM Hospede h WHERE h.nmHospede LIKE %:str%")
	public List<Hospede> findByNmHospede(@Param("str") String str);
	
	
	@Query("SELECT h FROM Hospede h WHERE h.cpf < :qtd")
	public List<Hospede> findByCpf(@Param("qtd") Integer qtd);
}

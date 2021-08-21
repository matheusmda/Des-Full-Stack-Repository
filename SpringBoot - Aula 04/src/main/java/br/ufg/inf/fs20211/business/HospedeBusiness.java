package br.ufg.inf.fs20211.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.repositories.HospedeRepository;


@Service
public class HospedeBusiness {

	@Autowired
	HospedeRepository repository;
	
	public List<Hospede> findAll(){
		return repository.findAll();
	}
	
	public Hospede findById(Integer id) {
		Optional<Hospede> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Hospede insert(Hospede hospede) {
		return repository.save(hospede);
	}
	
	public Hospede update(Hospede hospede) {
		return repository.save(hospede);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}

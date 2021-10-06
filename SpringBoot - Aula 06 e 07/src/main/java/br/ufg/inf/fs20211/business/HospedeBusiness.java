package br.ufg.inf.fs20211.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.exceptions.HospedeException;
import br.ufg.inf.fs20211.repositories.HospedeRepository;


@Service
public class HospedeBusiness {

	@Autowired
	HospedeRepository repository;
	
	public List<Hospede> findAll(){
		return repository.findAll();
	}
	
	public Page<Hospede> paginator(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	// new
	public List<Hospede> findName(String str){
		return repository.findByNmHospede(str);
	}
	
	// new
	public List<Hospede> findCpf(Integer qtd){
		return repository.findByCpf(qtd);
	}
	
	public Hospede findById(Integer id) {
		Optional<Hospede> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Hospede insert(Hospede hospede) throws HospedeException {
		this.validaHospede(hospede);
		return repository.save(hospede);
	}
	
	public Hospede update(Hospede hospede) throws HospedeException {
		this.validaHospede(hospede);
		return repository.save(hospede);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	// checa se campos de cpf e nome do hospede estão vazios
	private void validaHospede(Hospede hospede) throws HospedeException {
		if(hospede.getCpf() == null) {
			throw new HospedeException("0309");
		}
		if(hospede.getNmHospede() == null || hospede.getNmHospede().length() == 0) {
			throw new HospedeException("0308");
		}
	}
	
}

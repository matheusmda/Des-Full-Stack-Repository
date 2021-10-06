package br.ufg.inf.fs20211.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.exceptions.HospedagemException;
import br.ufg.inf.fs20211.repositories.HospedagemRepository;

@Service
public class HospedagemBusiness {

	@Autowired
	HospedagemRepository repository;
	
	public List<Hospedagem> findAll(){
		return repository.findAll();
	}
	
	public Page<Hospedagem> paginator(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public Hospedagem findById(Integer id) {
		Optional<Hospedagem> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException {
		this.validaHospedagem(hospedagem);
		return repository.save(hospedagem);
	}
	
	public Hospedagem update(Hospedagem hospedagem) throws HospedagemException {
		this.validaHospedagem(hospedagem);
		return repository.save(hospedagem);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	// Checa se data de checkout vem antes da data de checkin
	private void validaHospedagem(Hospedagem hospedagem) throws HospedagemException {
		if(hospedagem.getDtCheckin().compareTo(hospedagem.getDtCheckout()) > 0) {
			throw new HospedagemException("0209");
		}
	}
	
}

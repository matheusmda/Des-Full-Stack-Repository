package br.ufg.inf.fs20211.business;

import java.util.List;

import br.ufg.inf.fs20211.dao.DB;
import br.ufg.inf.fs20211.dao.HospedeDao;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.exceptions.HospedeException;


public class HospedeBusiness {

	HospedeDao dao = new HospedeDao(DB.getConnection());
	
	public List<Hospede> findAll(){
		return dao.findAll();
	}
	
	public Hospede findById(Integer id){
		return dao.findById(id);
	}
	
	public Hospede insert(Hospede hospede) throws HospedeException {
		
		return dao.insert(hospede);
	}

	public Hospede update(Hospede hospede) throws HospedeException {
		
		return dao.update(hospede);
	}

	public void delete(Integer i) throws HospedeException {
		dao.delete(i);
	}
	
}

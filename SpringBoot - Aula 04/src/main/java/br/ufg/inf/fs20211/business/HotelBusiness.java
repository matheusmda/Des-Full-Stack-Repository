package br.ufg.inf.fs20211.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.repositories.HotelRepository;

@Service
public class HotelBusiness {

	@Autowired
	HotelRepository repository;
	
	public List<Hotel> findAll(){
		return repository.findAll();
	}
	
	public Hotel findById(Integer id) {
		Optional<Hotel> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Hotel insert(Hotel hotel) {
		return repository.save(hotel);
	}
	
	public Hotel update(Hotel hotel) {
		return repository.save(hotel);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}

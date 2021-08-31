package br.ufg.inf.fs20211.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.exceptions.HotelException;
import br.ufg.inf.fs20211.repositories.HotelRepository;

@Service
public class HotelBusiness {

	@Autowired
	HotelRepository repository;
	
	public List<Hotel> findAll(){
		return repository.findAll();
	}
	
	// new
	public List<Hotel> findName(String str){
		return repository.findByNmHotel(str);
	}
	
	// new
	public List<Hotel> findEstelas(Integer qtd){
		return repository.findByQtdEstelas(qtd);
	}
	
	public Hotel findById(Integer id) {
		// new
		Optional<Hotel> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Hotel insert(Hotel hotel) throws HotelException {
		// new
		this.validaHotel(hotel);
		return repository.save(hotel);
	}
	
	public Hotel update(Hotel hotel) throws HotelException {
		this.validaHotel(hotel);
		return repository.save(hotel);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	// new
	private void validaHotel(Hotel hotel) throws HotelException {
		if(hotel.getNmHotel() == null || hotel.getNmHotel().length() == 0) {
			throw new HotelException("0109");
		}
		if(hotel.getQtdEstrelas() < 1 || hotel.getQtdEstrelas() > 5) {
			throw new HotelException("0108");
		}
		if(hotel.getEndereco() == null || hotel.getEndereco().length() == 0) {
			throw new HotelException("0110");
		}
	}
	
}

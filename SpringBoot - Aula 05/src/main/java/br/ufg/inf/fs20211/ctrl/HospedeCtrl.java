package br.ufg.inf.fs20211.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.fs20211.Messages;
import br.ufg.inf.fs20211.business.HospedeBusiness;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.exceptions.HospedeException;

@RestController
@RequestMapping(value="hospedes")
public class HospedeCtrl {

	@Autowired
	private HospedeBusiness business;

	@GetMapping
	public ResponseEntity<List<Hospede>> findAll(){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		List<Hospede> list = new ArrayList<Hospede>();
		try {
			list = business.findAll();
			if (list.size() == 0) {
				headers.add("message", Messages.get("0307"));
			}
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Messages.get("0002"));
		}
		return new ResponseEntity<List<Hospede>>(list, headers, status);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hospede> findById(@PathVariable Integer id){
		Hospede retorno = new Hospede();

		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		try {
			retorno = business.findById(id);
			if (retorno == null) {
				headers.add("message", Messages.get("0307"));
			}
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Messages.get("0002"));
		}
		return new ResponseEntity<Hospede>(retorno, headers, status);
	}
	
	@PostMapping
	public ResponseEntity<Hospede> insert(@RequestBody Hospede hospede){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			hospede = business.insert(hospede);
			headers.add("message", Messages.get("0301"));
		} catch (HospedeException e) {
			headers.add("message", Messages.get(e.getMessage()));
			status = HttpStatus.BAD_REQUEST;
		} catch (Exception e) {
			headers.add("message", Messages.get("0302"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} 
		return new ResponseEntity<Hospede>(hospede, headers, status);
	}
	
	@PutMapping
	public ResponseEntity<Hospede> update(@RequestBody Hospede hospede){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		try {
			hospede = business.update(hospede);
			headers.add("message", Messages.get("0303"));
		} catch (HospedeException e) {
			headers.add("message", Messages.get(e.getMessage()));
			status = HttpStatus.BAD_REQUEST;
		} catch (Exception e) {
			headers.add("message", Messages.get("0304"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} 
		return new ResponseEntity<Hospede>(hospede, headers, status);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.NO_CONTENT;
		
		try {
			business.delete(id);
		} catch (Exception e) {
			headers.add("message", Messages.get("0306"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Void>(headers, status);
	}
	
	@GetMapping("/nome/{str}")
	public ResponseEntity<List<Hospede>> findByName(@PathVariable String str){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		List<Hospede> list = new ArrayList<Hospede>();
		try {
			list = business.findName(str);
			if(list.size() == 0) {
				headers.add("message", Messages.get("0307"));
			}
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Messages.get("0002"));
		}
		return new ResponseEntity<List<Hospede>>(list, headers, status);

	}
	
	@GetMapping("/cpf/{qtd}")
	public ResponseEntity<List<Hospede>> findQtdEstrelas(@PathVariable Integer qtd){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		List<Hospede> list = new ArrayList<Hospede>();
		try {
			list = business.findCpf(qtd);
			if(list.size() == 0) {
				headers.add("message", Messages.get("0307"));
			}
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Messages.get("0002"));
		}
		return new ResponseEntity<List<Hospede>>(list, headers, status);

		
	}
}

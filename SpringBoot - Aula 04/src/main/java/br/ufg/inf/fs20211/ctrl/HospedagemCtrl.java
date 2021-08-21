package br.ufg.inf.fs20211.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.ufg.inf.fs20211.business.HospedagemBusiness;
import br.ufg.inf.fs20211.entities.Hospedagem;

@RestController
@RequestMapping(value = "hospedagens")
public class HospedagemCtrl {

	@Autowired
	private HospedagemBusiness business;

	@GetMapping
	public ResponseEntity<List<Hospedagem>> findAll() {
		List<Hospedagem> list = business.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hospedagem> findById(@PathVariable Integer id) {
		Hospedagem retorno = business.findById(id);
		return ResponseEntity.ok(retorno);
	}

	@PostMapping
	public ResponseEntity<Hospedagem> insert(@RequestBody Hospedagem hospedagem) {
		hospedagem = business.insert(hospedagem);
		return ResponseEntity.ok(hospedagem);
	}

	@PutMapping
	public ResponseEntity<Hospedagem> update(@RequestBody Hospedagem hospedagem) {
		hospedagem = business.update(hospedagem);
		return ResponseEntity.ok(hospedagem);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		business.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}

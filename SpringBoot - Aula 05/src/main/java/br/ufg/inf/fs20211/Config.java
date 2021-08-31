package br.ufg.inf.fs20211;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.entities.Quarto;
import br.ufg.inf.fs20211.enums.CategoriaQuarto;
import br.ufg.inf.fs20211.repositories.HospedagemRepository;
import br.ufg.inf.fs20211.repositories.HospedeRepository;
import br.ufg.inf.fs20211.repositories.HotelRepository;
import br.ufg.inf.fs20211.repositories.QuartoRepository;

@Configuration
@Profile("dev")
public class Config implements CommandLineRunner {

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private HospedeRepository hospedeRepository;

	@Autowired
	private HospedagemRepository hospedagemRepository;

	@Autowired
	private QuartoRepository quartoRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * INSERIR NO MEU BANCO DE DADOS INFORMAÇÕES INICIAIS...
		 * */
		
		Hotel h1 = new Hotel(null, "Calderao Odaruf", "Beco Lanogaid", 3);
		Hotel h2 = new Hotel(null, "Setab Hotel", "White Enip Yab", 2);
		Hotel h3 = new Hotel(null, "Hotel Overclock", "Odaroloc", 4);
		Hotel h4 = new Hotel(null, "Latnenitnoc Hotel", "Menino Ney City", 5);
		
		hotelRepository.save(h1);
		hotelRepository.save(h2);
		hotelRepository.save(h3);
		hotelRepository.save(h4);
		
		Date dateNasc = Date.valueOf("1996-05-04");
		Hospede ho1 = new Hospede(null, "Matheus Diniz", dateNasc, 456);
		dateNasc = Date.valueOf("6991-04-05");
		Hospede ho2 = new Hospede(null, "Suetham Zinid", dateNasc, 789);
		dateNasc = Date.valueOf("6991-04-05");
		Hospede ho3 = new Hospede(null, "Blyat Suka Idi Nahui", dateNasc, 333);
		
		 hospedeRepository.save(ho1);
		 hospedeRepository.save(ho2);
		 hospedeRepository.save(ho3);

		 Quarto q1 = new Quarto(null, h1, CategoriaQuarto.APARTAMENTO, 4, 1010, 200.0);
		 Quarto q2 = new Quarto(null, h2, CategoriaQuarto.SIMPLES, 1, 7, 100.0);
		 Quarto q3 = new Quarto(null, h3, CategoriaQuarto.PADRAO, 2, 306, 150.0);
		 Quarto q4 = new Quarto(null, h4, CategoriaQuarto.LUXO, 3, 1313, 500.0);
		 
		 quartoRepository.save(q1);
		 quartoRepository.save(q2);
		 quartoRepository.save(q3);
		 quartoRepository.save(q4);
		 
		 Date datein = Date.valueOf("2020-08-21");
		 Date dateout = Date.valueOf("2021-08-21");
		 Hospedagem hos1 = new Hospedagem(null, ho1.getIdHospede(), q1.getIdQuarto(), datein, dateout);
		 datein = Date.valueOf("2020-12-23");
		 dateout = Date.valueOf("2021-12-24");
		 Hospedagem hos2 = new Hospedagem(null, ho2.getIdHospede(), q2.getIdQuarto(), datein, dateout);
		 
		 hospedagemRepository.save(hos1);
		 hospedagemRepository.save(hos2);
	}

}

package br.ufg.inf.fs20211;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.entities.Quarto;
import br.ufg.inf.fs20211.entities.Regra;
import br.ufg.inf.fs20211.entities.Usuario;
import br.ufg.inf.fs20211.enums.CategoriaQuarto;
import br.ufg.inf.fs20211.repositories.HospedagemRepository;
import br.ufg.inf.fs20211.repositories.HospedeRepository;
import br.ufg.inf.fs20211.repositories.HotelRepository;
import br.ufg.inf.fs20211.repositories.QuartoRepository;
import br.ufg.inf.fs20211.repositories.RegraRepository;
import br.ufg.inf.fs20211.repositories.UsuarioRepository;

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
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RegraRepository regraRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * INSERIR NO MEU BANCO DE DADOS INFORMAÇÕES INICIAIS...
		 * */
		
		String [] tipoH = new String[]{"Hotel", "Pousada", "Resort", "Hostel", "Pensão"};
		String [] nomeH = new String[]{"sod Sodassáp", "sad Same", "sod Setnargimi", "ad Airgela", "ad Edadic"};
		String [] localH = new String[]{"Goiânia", "Anápolis", "Brasília", "Trindade", "Senador Canedo"};
		
		for(int i = 0;i < 100;i++) {
			hotelRepository.save(new Hotel(
					null,
					tipoH[new Random().nextInt(5)]+" "+nomeH[new Random().nextInt(5)],
					localH[new Random().nextInt(5)],
					new Random().nextInt(5)+1
					));
		}
		
		String [] cpfHosp = new String[]{"123", "321", "456", "654", "789"};
		Date dateNasc1 = Date.valueOf("1996-05-04");
		Date dateNasc2 = Date.valueOf("2000-08-07");
		Date dateNasc3 = Date.valueOf("1976-05-24");
		Date dateNasc4 = Date.valueOf("1996-12-08");
		Date dateNasc5 = Date.valueOf("2002-09-30");
		Date [] dtNascHosp = new Date[]{dateNasc1, dateNasc2, dateNasc3, dateNasc4, dateNasc5};
		String [] nomeHosp = new String[]{"Suetham", "Zinid", "Racnela", "Tristam", "Fulaninho"};
		
		for(int i = 0;i < 100;i++) {
			hospedeRepository.save(new Hospede(
					null,
					nomeHosp[new Random().nextInt(5)],
					dtNascHosp[new Random().nextInt(5)],
					cpfHosp[new Random().nextInt(5)]
					));
		}
		

		Date datein1 = Date.valueOf("1996-05-04");
		Date dateout1 = Date.valueOf("2000-08-07");
		Date datein2 = Date.valueOf("1997-05-04");
		Date dateout2 = Date.valueOf("2000-08-07");
		Date datein3 = Date.valueOf("1999-05-04");
		Date dateout3 = Date.valueOf("2000-08-07");
		Date datein4 = Date.valueOf("1995-05-04");
		Date dateout4 = Date.valueOf("2000-08-07");
		Date datein5 = Date.valueOf("1996-05-04");
		Date dateout5 = Date.valueOf("2000-08-07");
		Date [] dtin = new Date[]{datein1, datein2, datein3, datein4, datein5};
		Date [] dtout = new Date[]{dateout1, dateout2, dateout3, dateout4, dateout5};
		Integer [] idHosp = new Integer[]{55, 18, 94, 100, 2};
		Integer [] idQuarto = new Integer[]{1, 2, 3, 4};
		
		for(int i = 0;i < 100;i++) {
			hospedagemRepository.save(new Hospedagem(
					null,
					idQuarto[new Random().nextInt(4)],
					idHosp[new Random().nextInt(5)],
					dtin[new Random().nextInt(5)],
					dtout[new Random().nextInt(5)]
					));
		}
		
		Hotel h1 = new Hotel(null, "Calderao Odaruf", "Beco Lanogaid", 3);
		Hotel h2 = new Hotel(null, "Setab Hotel", "White Enip Yab", 2);
		Hotel h3 = new Hotel(null, "Hotel Overclock", "Odaroloc", 4);
		Hotel h4 = new Hotel(null, "Latnenitnoc Hotel", "Menino Ney City", 5);
		
		hotelRepository.save(h1);
		hotelRepository.save(h2);
		hotelRepository.save(h3);
		hotelRepository.save(h4);
		
		Date dateNasc = Date.valueOf("1996-05-04");
		Hospede ho1 = new Hospede(null, "Matheus Diniz", dateNasc, "456");
		dateNasc = Date.valueOf("6991-04-05");
		Hospede ho2 = new Hospede(null, "Suetham Zinid", dateNasc, "789");
		dateNasc = Date.valueOf("6991-04-05");
		Hospede ho3 = new Hospede(null, "Blyat Suka Idi Nahui", dateNasc, "333");
		
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
		 
		 Regra r1 = regraRepository.save(new Regra ("ADMIN"));
		 Regra r2 = regraRepository.save(new Regra ("USER"));
		 Regra r3 = regraRepository.save(new Regra ("GUEST"));
		 
		 List<Regra> regras = new ArrayList<Regra>();
		 
		 regras.add(r1);
		 regras.add(r2);
		 
		 PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		 Usuario usu1 = usuarioRepository.save(new Usuario("luiz", "Luiz Martins", encoder.encode("4321"), regras));
		 
		 regras = new ArrayList<Regra>();
		 
		 regras.add(r2);
		 regras.add(r3);
		 
		 Usuario usu2 = usuarioRepository.save(new Usuario("jose", "Jose Silva", encoder.encode("asdf"), regras));
		 
	}

}

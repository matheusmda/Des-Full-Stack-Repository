package br.ufg.inf.fs20211.config;

import java.sql.Date;

import br.ufg.inf.fs20211.ctrl.HospedagemCtrl;
import br.ufg.inf.fs20211.ctrl.HospedeCtrl;
import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.entities.Hospede;

public class App {

	public static void main(String[] args) {

		System.out.println("Começando");

		HospedeCtrl hospedeCtrl = new HospedeCtrl();
		HospedagemCtrl hospedagemCtrl = new HospedagemCtrl();
		
		System.out.println("Busca Todos - Hospedes");
		for(Hospede h : hospedeCtrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Busca Todos - Hospedagens");
		for(Hospedagem h : hospedagemCtrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Busca por ID - Hospedes");
		System.out.println(hospedeCtrl.findById(1));
		
		System.out.println("Busca por ID - Hospedagens");
		System.out.println(hospedagemCtrl.findById(1));
		
		System.out.println("Inserir no Banco - Hospede");
		Date dateNasc = Date.valueOf("2000-08-20");
		Hospede hospede = new Hospede(null, "Fulano do Teste", dateNasc, 987);
		hospede = hospedeCtrl.insert(hospede);
		System.out.println(hospede);
		
		System.out.println("Inserir no Banco - Hospedagem");
		Date datein = Date.valueOf("2000-08-20");
		Date dateout = Date.valueOf("2000-01-09");
		Hospedagem hospedagem = new Hospedagem(null, 1, 1, datein, dateout);
		hospedagem = hospedagemCtrl.insert(hospedagem);
		System.out.println(hospedagem);
		
		System.out.println("Alterar no Banco - Hospede");
		hospede.setNmHospede("Ciclano Testador");
		hospede = hospedeCtrl.update(hospede);
		System.out.println(hospede);
		
		System.out.println("Alterar no Banco - Hospedagem");
		datein = Date.valueOf("2000-08-21");
		hospedagem.setDtCheckin(datein);
		hospedagem = hospedagemCtrl.update(hospedagem);
		System.out.println(hospedagem);
		
		System.out.println("Excluir - Hospede");
		hospedeCtrl.delete(hospede.getIdHospede());
		
		System.out.println("Excluir - Hospedagem");
		hospedagemCtrl.delete(hospedagem.getIdHospedagem());
		
		System.out.println("Terminou");

	}

//	public static void testeJpa() {
//
//		System.out.println("Começando");
//
//		EntityManager em = DaoFactory.getEntityManager();
//
//		// CREATE
//		/*
//		 * // Hotel hotel = new Hotel(null, "Suetham's Krap Hotel", "Acre", 5);
//		 * 
//		 * // Quarto quarto = new Quarto(null, hotel, CategoriaQuarto.LUXO, 5, 256,
//		 * 500.00);
//		 * 
//		 * // Date dateNasc = Date.valueOf("1996-04-05"); // Hospede hospede = new
//		 * Hospede(null, "Matheus Parker", dateNasc, 830);
//		 * 
//		 * // Date datein = Date.valueOf("2051-04-05"); // Date dateout =
//		 * Date.valueOf("2051-04-07"); // Hospedagem hospedagem = new Hospedagem(null,
//		 * quarto.getIdQuarto(), hospede.getIdHospede(), datein, dateout);
//		 * 
//		 * em.getTransaction().begin(); // em.persist(hotel);
//		 * 
//		 * Hotel h1 = new Hotel(null, "Sibi", "Ainaiog", 3); Hotel h2 = new Hotel(null,
//		 * "Anabacapoc Palace", "Rio de Orienaj", 5); Hotel h3 = new Hotel(null,
//		 * "Ilanedi Hotel", "Silopana", 4);
//		 * 
//		 * em.persist(h1); em.persist(h2); em.persist(h3);
//		 * 
//		 * // em.persist(quarto); // em.persist(hospede); // em.persist(hospedagem);
//		 * em.getTransaction().commit();
//		 */
//
//		// READ ALL
//		/*
//		 * System.out.println("Buscar Todos"); TypedQuery<Hotel> result =
//		 * em.createQuery("from Hotel", Hotel.class); List<Hotel> hoteis =
//		 * result.getResultList(); for(Hotel h : hoteis) { System.out.println(h); }
//		 * 
//		 * 
//		 * 
//		 * // READ BY ID Hotel h4 = em.find(Hotel.class, 6);
//		 * 
//		 * System.out.println("Buscar Por ID"); System.out.println(h4);
//		 * 
//		 * // READ BY OCCURRENCE System.out.println("Buscar por Ocorrência"); String sql
//		 * = "from Hotel h where h.nmHotel like :str"; TypedQuery<Hotel> result2 =
//		 * em.createQuery(sql, Hotel.class); result2.setParameter("str", "%a%"); hoteis
//		 * = result2.getResultList(); for(Hotel h : hoteis) { System.out.println(h); }
//		 */
//
//		System.out.println("Update do Objeto");
//		Hotel hotelUpdate = em.find(Hotel.class, 5);
//
//		hotelUpdate.setNmHotel("Sibi Hostel");
//		em.getTransaction().begin();
//		em.persist(hotelUpdate);
//		em.getTransaction().commit();
//
//		System.out.println("Delete do Objeto");
//
//		/*
//		 * Hotel hotelDeleta = new Hotel(null, "Hotel Santo Oinotna", "Siloporen", 3);
//		 * System.out.println(hotelDeleta); System.out.println("persistindo");
//		 * em.getTransaction().begin(); em.persist(hotelDeleta);
//		 * em.getTransaction().commit(); System.out.println("novo objeto");
//		 * System.out.println(hotelDeleta);
//		 */
//
//		/*
//		 * Hotel hotelDeleta = em.find(Hotel.class, 8);
//		 * 
//		 * em.getTransaction().begin(); em.remove(hotelDeleta);
//		 * em.getTransaction().commit();
//		 */
//
//		DaoFactory.closeConnection();
//
//		System.out.println("Terminou");
//
//	}
}

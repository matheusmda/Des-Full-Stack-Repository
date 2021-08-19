package br.ufg.inf.fs20211;

import java.sql.Date;

import br.ufg.inf.fs20211.ctrl.HotelCtrl;
import br.ufg.inf.fs20211.ctrl.QuartoCtrl;
import br.ufg.inf.fs20211.ctrl.HospedagemCtrl;
import br.ufg.inf.fs20211.ctrl.HospedeCtrl;
import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.entities.Quarto;
import br.ufg.inf.fs20211.enums.CategoriaQuarto;

public class App {

	public static void main(String[] args) {
		
		testeCrudHospedagem();
		testeCrudHospede();
//		testeCrudHotel();
//		testeCrudQuarto();
	}

	public static void testeCrudHospedagem() {
		
		HospedagemCtrl ctrl = new HospedagemCtrl();
		
		System.out.println("Listando Todas as Hospedagens");
		for(Hospedagem h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Hospedagem #ID 123");
		
		Hospedagem h123 = ctrl.findById(123);
		
		System.out.println(h123);
		
		System.out.println("Inserindo uma nova Hospedagem");
		
		Date datein = Date.valueOf("2021-01-11");
		Date dateout = Date.valueOf("2021-02-25");
		
		Hospedagem h124 = new Hospedagem(null, 1, 128, datein, dateout);
		
		Hospedagem h125 = ctrl.insert(h124);
		System.out.println(h125);
		
		Hospedagem h2 = ctrl.findById(130);
		System.out.println("Update");
		System.out.println("#ID original: "+h2);
		dateout = Date.valueOf("2021-10-01");
		h2.setDtCheckout(dateout);
		h2 = ctrl.update(h2);
		System.out.println("#ID ALTERADO: "+h2);			
		System.out.println("Lista de Hospedagens Atualizada");
		for(Hospedagem h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Deletar #ID 129");
		ctrl.delete(129);
		System.out.println("Lista de Hospedes Atualizada");
		for(Hospedagem h : ctrl.findAll()) {
			System.out.println(h);
		}
		
	}
	
	private static void testeCrudHospede() {
		
		HospedeCtrl ctrl = new HospedeCtrl();
		
		System.out.println("Listando Todos os Hospedes");
		for(Hospede h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Hospede #ID 123");
		
		Hospede h123 = ctrl.findById(123);
		
		System.out.println(h123);
		
		System.out.println("Inserindo um novo Hospede");
		
		Date datenasc = Date.valueOf("4444-01-01");
		
		Hospede h124 = new Hospede(null, "Obi-Wan", datenasc, 156);
		
		Hospede h125 = ctrl.insert(h124);
		System.out.println(h125);
		
		Hospede h2 = ctrl.findById(129);
		System.out.println("Update");
		System.out.println("#ID original: "+h2);
		h2.setNmHospede("Obi-Wan Kenobi");
		h2 = ctrl.update(h2);
		System.out.println("#ID ALTERADO: "+h2);			
		System.out.println("Lista de Hospedes Atualizada");
		for(Hospede h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Deletar #ID 127");
		ctrl.delete(127);
		System.out.println("Lista de Hospedes Atualizada");
		for(Hospede h : ctrl.findAll()) {
			System.out.println(h);
		}
	}
	
	public static void testeCrudHotel() {
		
		HotelCtrl ctrl = new HotelCtrl();
		
		System.out.println("Lista de Hoteis Cadastrados");
		for(Hotel h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Buscar pelo #ID 1");
		Hotel hotel = ctrl.findById(1);
		System.out.println(hotel);
		
		System.out.println("Cadastrar novo Hotel");
		
		Hotel h1 = new Hotel(null, "Hotel Goiânia", "Goiânia", 3);
		h1 = ctrl.insert(h1);
		System.out.println(h1);
		
		Hotel h2 = ctrl.findById(3);
		System.out.println("UPDATE");
		System.out.println("#ID original: "+h2);
		h2.setNmHotel(h2.getNmHotel()+" ALTERADO");
		h2 = ctrl.update(h2);
		System.out.println("#ID alterado: "+h2);
		
		
		System.out.println("Lista de Hoteis Cadastrados");
		for(Hotel h : ctrl.findAll()) {
			System.out.println(h);
		}
		System.out.println("Deletar #ID 4");
		ctrl.delete(4);
		
		System.out.println("Lista de Hoteis Atualizado");
		for(Hotel h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		
	}
	
	public static void testeCrudQuarto() {
		
		QuartoCtrl ctrl = new QuartoCtrl();
		
		HotelCtrl hotelCtrl = new HotelCtrl();
		
		System.out.println("Lista de Quartos Cadastrados");
		for(Quarto q : ctrl.findAll()) {
			System.out.println(q);
		}
		
		System.out.println("Buscar pelo #ID 1");
		Quarto quarto = ctrl.findById(1);
		System.out.println(quarto);
		
		System.out.println("Cadastrar novo Quarto");
		
		Quarto q1 = new Quarto(null, 
					hotelCtrl.findById(1), 
					CategoriaQuarto.APARTAMENTO, 
					3,
					120,
					240.0);
//		q1 = ctrl.insert(q1);
		System.out.println(q1);
		
		Quarto q2 = ctrl.findById(1);
		System.out.println("UPDATE");
		System.out.println("#ID original: "+q2);
		q2.setPrDiaria(q2.getPrDiaria()+20);
		q2 = ctrl.update(q2);
		System.out.println("#ID alterado: "+q2);
		
		
		System.out.println("Lista de Quartos Cadastrados");
		for(Quarto h : ctrl.findAll()) {
			System.out.println(h);
		}
		System.out.println("Deletar #ID 3");
		ctrl.delete(3);
		
		System.out.println("Lista de Quartos Atualizado");
		for(Quarto q : ctrl.findAll()) {
			System.out.println(q);
		}
		
		
	}

}

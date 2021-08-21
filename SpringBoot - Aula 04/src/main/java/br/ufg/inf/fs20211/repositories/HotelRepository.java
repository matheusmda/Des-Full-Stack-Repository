package br.ufg.inf.fs20211.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fs20211.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}

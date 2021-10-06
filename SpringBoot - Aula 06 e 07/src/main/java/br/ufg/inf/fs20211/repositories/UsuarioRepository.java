package br.ufg.inf.fs20211.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ufg.inf.fs20211.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public Usuario findByLogin(String login);
	
}

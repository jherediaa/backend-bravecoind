package com.api.bravecoin.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.bravecoin.data.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, String> {

	@Query(nativeQuery = true, value = "select * from usuario where username = :usuario and contrasenia = :password")
	public List<Usuario> getUsuario(@Param("usuario") String usuario, @Param("password") String password);

}

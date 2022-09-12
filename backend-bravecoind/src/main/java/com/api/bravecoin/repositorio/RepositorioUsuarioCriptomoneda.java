package com.api.bravecoin.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.bravecoin.data.UsuarioCriptomoneda;

@Repository
public interface RepositorioUsuarioCriptomoneda extends JpaRepository<UsuarioCriptomoneda, Long> {

	@Query(nativeQuery = true, value = "select * from usuario_criptomoneda where usuario = :usuario")
	public List<UsuarioCriptomoneda> getMonedas(@Param("usuario") String usuario);

	@Query(nativeQuery = true, value = "select * from usuario_criptomoneda where usuario = :usuario order by precio desc  limit 3")
	public List<UsuarioCriptomoneda> getMonedasTop3(String usuario);

}

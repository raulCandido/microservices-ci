package br.com.candido.cambioservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.candido.cambioservice.model.Cambio;

@Repository
public interface CambioRepository extends JpaRepository<Cambio, Long>{

    Cambio findByFromAndTo(String from, String to);
}

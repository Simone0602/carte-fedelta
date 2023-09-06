package com.example.cartefedelta.carte.repository;

import com.example.cartefedelta.carte.model.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface CarteRepository extends JpaRepository<Carta, Long> {

    @Query(value = "SELECT num_carta FROM carta ORDER BY id DESC LIMIT 1", nativeQuery = true)
    public List<String> findLastNumCarta();

    @Query(value = "SELECT * FROM carta WHERE stato = 0 ORDER BY random() LIMIT 1", nativeQuery = true)
    public List<Carta> cartaAssociata();

}

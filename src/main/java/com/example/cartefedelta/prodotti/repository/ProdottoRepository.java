package com.example.cartefedelta.prodotti.repository;

import com.example.cartefedelta.prodotti.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

    @Query(value = "SELECT * FROM prodotto ORDER BY random() LIMIT 1", nativeQuery = true)
    public List<Prodotto> getProdottoCasuale();
}

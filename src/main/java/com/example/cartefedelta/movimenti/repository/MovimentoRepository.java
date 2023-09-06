package com.example.cartefedelta.movimenti.repository;

import com.example.cartefedelta.movimenti.model.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
}

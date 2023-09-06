package com.example.cartefedelta.movimenti.repository;

import com.example.cartefedelta.movimenti.model.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
    @Query(value = "SELECT * FROM movimento WHERE dataora = :data", nativeQuery = true)
    public List<Movimento> findByData(@Param("data") LocalDateTime data);
}

package com.example.cartefedelta.clienti.repository;

import com.example.cartefedelta.clienti.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientiRepository extends JpaRepository<Cliente,Long>, PagingAndSortingRepository<Cliente, Long> {

}

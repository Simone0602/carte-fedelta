package com.example.cartefedelta.prodotti.controller;

import com.example.cartefedelta.prodotti.model.Prodotto;
import com.example.cartefedelta.prodotti.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/prodotto")
public class ProdottoController {

    @Autowired
    private ProdottoRepository prodottoRepository;

    @PostMapping
    public @ResponseBody String addProdotto (@RequestBody Prodotto prodotto) {
        prodottoRepository.save(prodotto);
        return "Saved " + prodotto.toString();
    }

    @GetMapping("/prodotti")
    public @ResponseBody Iterable<Prodotto> getAllProdotti(){return prodottoRepository.findAll();}

    @GetMapping(path = "/{id}")
    public @ResponseBody Prodotto findById(
            @PathVariable(name = "id") Long id){
        return prodottoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prodotto non trovato")
        );
    }

    //Questa get mi ritorna o un HttpStatus o una List di Prodotto
    @GetMapping(path = "/casuale")
    public ResponseEntity<List<Prodotto>> findProdottoCasuale() {
        List<Prodotto> prodotto = prodottoRepository.getProdottoCasuale();
        if (prodotto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(prodotto, HttpStatus.OK);
        }
    }


}

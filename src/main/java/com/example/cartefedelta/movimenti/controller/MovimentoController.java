package com.example.cartefedelta.movimenti.controller;

import com.example.cartefedelta.movimenti.model.Movimento;
import com.example.cartefedelta.movimenti.repository.MovimentoRepository;
import com.example.cartefedelta.prodotti.model.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/movimento")
public class MovimentoController {

    @Autowired
    private MovimentoRepository movimentoRepository;

    @GetMapping("/movimenti")
    public @ResponseBody Iterable<Movimento> getMovimenti(){
        return movimentoRepository.findAll();
    }

    @GetMapping("/{data}")
    public ResponseEntity<List<Movimento>> getMovimentoData(@PathVariable(name = "data") LocalDateTime data){
        List<Movimento> movimenti = movimentoRepository.findByData(data);
        if(movimenti.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(movimenti, HttpStatus.OK);
        }
    }



}

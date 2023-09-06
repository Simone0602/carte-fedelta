package com.example.cartefedelta.carte.controller;

import com.example.cartefedelta.carte.Stato;
import com.example.cartefedelta.carte.dto.CreateCarteDto;
import com.example.cartefedelta.carte.model.Carta;
import com.example.cartefedelta.carte.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/carta")
public class CarteController {

@Autowired
private CarteRepository carteRepository;

    @GetMapping("/carte")
    public @ResponseBody Iterable<Carta> getAll(){
        return carteRepository.findAll();
    }

    @PostMapping("/add/carte")
    public ResponseEntity<String> createCarte(@RequestBody CreateCarteDto numCarte) {
        List<String> lastNumCarta = carteRepository.findLastNumCarta();
        String num;
        if (lastNumCarta.isEmpty()){
            num = "000000000001";
        }else {
            num = String.format("%012d", Long.parseLong(lastNumCarta.get(0)) + 1);
        }
        List<Carta> carte = new ArrayList<>();
        int numCardsToAdd = numCarte.getNumCarte();

        for (int i = 0; i < numCardsToAdd; i++) {
            Carta carta = new Carta();
            carta.setNum_carta(num);
            Date now = new Date();
            carta.setData_creazione(now);
            carta.setStato(Stato.CREATA);
            carte.add(carta);

            // Incrementa num ad ogni iterazione
            num = String.format("%012d", Long.parseLong(num) + 1);
        }

        carteRepository.saveAll(carte);

        return new ResponseEntity<>("Carte create", HttpStatus.OK);
    }
}

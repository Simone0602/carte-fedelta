package com.example.cartefedelta.carte.controller;

import com.example.cartefedelta.carte.Stato;
import com.example.cartefedelta.carte.model.Carta;
import com.example.cartefedelta.carte.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/carta")
public class CarteController {

@Autowired
private CarteRepository carteRepository;

/*@Autowired
public void MyCarteController(CarteRepository carteRepository) {
    this.carteRepository = carteRepository;
}*/

    @GetMapping("/carte")
    public @ResponseBody Iterable<Carta> getAll(){
        return carteRepository.findAll();
    }
    @PostMapping("/add/carte")
    public @ResponseBody String createCarte() {
        String num = "000000000001";
        List<Carta> carte = new ArrayList<>();
        int numCardsToAdd = 1000;

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
        return "Carte create";
    }
}

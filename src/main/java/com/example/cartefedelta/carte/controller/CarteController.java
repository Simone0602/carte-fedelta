package com.example.cartefedelta.carte.controller;

import com.example.cartefedelta.carte.Stato;
import com.example.cartefedelta.carte.dto.AssociazioneCartaDto;
import com.example.cartefedelta.carte.dto.CreateCarteDto;
import com.example.cartefedelta.carte.model.Carta;
import com.example.cartefedelta.carte.repository.CarteRepository;
import com.example.cartefedelta.clienti.controller.ClientiController;
import com.example.cartefedelta.clienti.model.Cliente;
import com.example.cartefedelta.clienti.repository.ClientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/carta")
public class CarteController {

@Autowired
private CarteRepository carteRepository;
@Autowired
private ClientiRepository clientiRepository;

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

    @PutMapping("/cliente/{id}")
    public ResponseEntity<String> associazioneCartaCliente(@PathVariable(name = "id") Long id) {
        if (id != null) {
            Optional<Cliente> clienteOptional = clientiRepository.findById(id);

            if (clienteOptional.isPresent()) {
                Cliente cliente = clienteOptional.get();
                List<Carta> card = carteRepository.cartaAssociata();
                Date now = new Date();

                if (card.isEmpty()) {
                    return new ResponseEntity<>("Creare nuove carte", HttpStatus.NO_CONTENT);
                } else {
                    Carta carta = card.get(0);
                    carta.setCliente(cliente);
                    carta.setData_validazione(now);
                    carta.setStato(Stato.ATTIVA);
                    carta.setPunti(0L);
                    carteRepository.save(carta);
                    return new ResponseEntity<>("Carta associata", HttpStatus.OK);
                }
            } else {
                return new ResponseEntity<>("Cliente non trovato", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("ID cliente non valido", HttpStatus.BAD_REQUEST);
        }
    }
}

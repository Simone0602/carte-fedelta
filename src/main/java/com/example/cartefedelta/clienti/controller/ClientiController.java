package com.example.cartefedelta.clienti.controller;

import com.example.cartefedelta.clienti.model.Cliente;
import com.example.cartefedelta.clienti.repository.ClientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping(path = "/cliente")
public class ClientiController {

    @Autowired
    private ClientiRepository repository;

    @PostMapping // Map ONLY POST Requests
    public @ResponseBody String addCliente (@RequestBody Cliente cliente) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        repository.save(cliente);
        return "Saved " + cliente.toString();
    }

    @GetMapping(path = "/clienti")
    public @ResponseBody Iterable<Cliente> getAll(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Cliente findById(
            @PathVariable(name = "id") Long id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente non trovato")
        );
    }

    @DeleteMapping(path = "/cliente/{id}")
    public @ResponseBody String deleteById(
            @PathVariable(name = "id") Long id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return "Cliente Eliminato";
        }
        return "Cliente non trovato";
    }
}

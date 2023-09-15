package com.example.cartefedelta;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class.getName());

    @PostMapping("/caricamento")
    public String caricamentoFile(@RequestParam("file")MultipartFile file){
        if(!file.isEmpty()){
            try{
                log.info("Stampa del file: ");
                log.info(new String(file.getBytes()));
                return "File caricato con successo";
            }catch (Exception e){
                return "Errore durante il caricamento del file: " + e.getMessage();
            }
        }else{
            return "Il file è vuoto";
        }
    }

}

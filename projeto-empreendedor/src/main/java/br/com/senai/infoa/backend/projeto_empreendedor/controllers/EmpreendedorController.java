package br.com.senai.infoa.backend.projeto_empreendedor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.infoa.backend.projeto_empreendedor.services.EmpreendedorService;


@RestController // serve para indicar que essa classe, é uma classe controladora, uma classe controladora é onde definimos as requisições
@RequestMapping("/empreendedor") // serve para indicar qual é a URN ou caminho desse contorlador
public class EmpreendedorController {
    
    @Autowired 
    private EmpreendedorService empreendedorService;

    @GetMapping("/contar") //get é o contar
    public Long contar() {
        return empreendedorService.contar();
    }
    
}

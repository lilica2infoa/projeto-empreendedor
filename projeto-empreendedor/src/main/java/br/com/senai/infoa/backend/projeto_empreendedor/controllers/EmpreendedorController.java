package br.com.senai.infoa.backend.projeto_empreendedor.controllers;

import br.com.senai.infoa.backend.projeto_empreendedor.repositories.EmpreendedorRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.infoa.backend.projeto_empreendedor.models.Empreendedor;
import br.com.senai.infoa.backend.projeto_empreendedor.services.EmpreendedorService;



@RestController // serve para indicar que essa classe, é uma classe controladora, uma classe controladora é onde definimos as requisições
@RequestMapping("/empreendedor") // serve para indicar qual é a URN ou caminho desse contorlador
public class EmpreendedorController {
    
    private final EmpreendedorRepository empreendedorRepository;
    @Autowired 
    private EmpreendedorService empreendedorService;

    EmpreendedorController(EmpreendedorRepository empreendedorRepository) {
        this.empreendedorRepository = empreendedorRepository;
    }

    @GetMapping("/contar") //get é o contar
    public Long contar() {
        return empreendedorService.contar();
    }

    @GetMapping("/listar")
    public List<Empreendedor> listar() {
        return empreendedorService.listar();
    }
    @GetMapping("/buscar/{id}") //o @PathVariable é o formato em caixinha
    public Empreendedor buscarPorid(@PathVariable Integer id) {
        return empreendedorService.buscarPorid(id);
    }
}

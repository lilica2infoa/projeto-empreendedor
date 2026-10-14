package br.com.senai.infoa.backend.projeto_empreendedor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.infoa.backend.projeto_empreendedor.repositories.EmpreendedorRepository;


@Service 
public class EmpreendedorService {
    
    @Autowired //É a injeção de dependência, significa chamar o repositorio, a partir desse comando
    private EmpreendedorRepository empreendedorRepository; //O serviço irá chamar o repositório 

    //Consulta de contagem
    //Long é um numero inteira porém é grande
    public Long contar(){
        return empreendedorRepository.count(); 
    }
}

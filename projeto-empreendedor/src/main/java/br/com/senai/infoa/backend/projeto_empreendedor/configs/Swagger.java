package br.com.senai.infoa.backend.projeto_empreendedor.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Comércio panificação M.r Toledo",
        version = "1.0",
        description = "API para o sistema de um comercio de panificação M.r Toledo"
    )
)
public class Swagger {

}

package com.dev.Cadastro.Carros;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CarroController {
    @GetMapping("/boasVindas2")
    public  String boasVindas() {
        return "Essa é minha 2° mensagem nessa rota!";
    }
}

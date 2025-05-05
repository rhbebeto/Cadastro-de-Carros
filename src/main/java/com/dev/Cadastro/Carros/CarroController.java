package com.dev.Cadastro.Carros;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carros")
public class CarroController {
    @GetMapping("/boasVindas2")
    public  String boasVindas() {
        return "Essa é minha 2° mensagem nessa rota!";
    }

    @PostMapping("/criar")
    public String criarCarro (){
        return "Criar carro!";

    }

    @PutMapping("/alterar")
    public String alterarCarro(){
        return "Alterar carro!";

    }

    @GetMapping ("/listar")
    public String listarCarro(){
        return "Listar carros!";

    }

    @DeleteMapping("/deletar")
    public String deletarCarro(){
        return "Deleta carro";
    }


}

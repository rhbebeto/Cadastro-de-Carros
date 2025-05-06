package com.dev.Cadastro.Carros;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

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
    public List<CarroModel> listarCarro(){
        return carroService.listarCarros();

    }

    @GetMapping ("/listar/{id}")
    public CarroModel listarPorId(@PathVariable Long id){
        return carroService.listarPorId(id);
    }

    @DeleteMapping("/deletar")
    public String deletarCarro(){
        return "Deleta carro";
    }


}

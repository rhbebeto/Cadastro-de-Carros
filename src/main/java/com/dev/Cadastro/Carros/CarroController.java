package com.dev.Cadastro.Carros;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    private CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping("/boasVindas2")
    public  String boasVindas() {
        return "Essa é minha 2° mensagem nessa rota!";
    }


    //Criar
    @PostMapping("/criar")
    public CarroDTO criar(@RequestBody CarroDTO carro) {
        return carroService.criarCarro(carro) ;
    }


    @PutMapping("/alterar")
    public String alterarCarro(){
        return "Alterar carro!";

    }

    @GetMapping ("/listar")
    public List<CarroDTO> listarCarro(){
        return carroService.listarCarros();

    }

    @GetMapping ("/listar/{id}")
    public CarroDTO listarPorId(@PathVariable Long id){
        return carroService.listarPorId(id);
    }


    @DeleteMapping("/deletar/{id}")
    public String deletarCarro(@PathVariable Long id) {
        carroService.deletarCarro(id);
        return "Deleteado com sucesso!";
    }

    //Alterar
    @PutMapping("alterar/{id}")
    public CarroDTO atualizarCarro(@PathVariable Long id, @RequestBody CarroDTO carroDTO){
     return carroService.atualizarCarro(id,carroDTO);
    }



}

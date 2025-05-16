package com.dev.Cadastro.Carros;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criar(@RequestBody CarroDTO carro) {
        CarroDTO carroNovo = carroService.criarCarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Carro adicionado com sucesso:" + carroNovo.getModelo() + " ID: "+carroNovo.getId());
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
    public ResponseEntity<String> deletarCarro(@PathVariable Long id) {

        if (carroService.listarPorId(id) != null){
            carroService.deletarCarro(id);
            return ResponseEntity.ok("Carro com id " + id + " deletado com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carro de id "+ id +"  não existe.");
        }
    }

    //Alterar
    @PutMapping("alterar/{id}")
    public ResponseEntity<String> atualizarCarro(@PathVariable Long id, @RequestBody CarroDTO carroDTO){
        if (carroService.listarPorId(id)!= null){
            carroService.atualizarCarro(id, carroDTO);
            return ResponseEntity.ok("Carro com id " + id + " atualizado com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carro de id "+ id +"  não existe.");        }

    }



}

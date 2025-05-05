package com.dev.Cadastro.Proprietarios;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {
    @GetMapping("/boasVindas")
    public  String boasVindas() {

        return "Essa é minha 1° mensagem nessa rota!";
    }

    //Criar
    @PostMapping("/criar")
    public String criar() {
        return "proprietario criado";
    }


    //Mostrar
    @GetMapping("/todos")
    public String mostrarTodosProprietario(){

        return "mostrados";

    }

    //procurar
    @GetMapping("/todosID")
    public String mostrarTodosProprietarioID(){

        return "mostrados";

    }
    //alter
    @PutMapping("/alterarID")
    public String alterarProprietarioID(){
        return "Altereado";
    }

    //deletar
    @DeleteMapping("/deletarID")
    public String deletarId(){
        return "Deletar";
    }
}

package com.dev.Cadastro.Proprietarios;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {

    //injeção de service
    private ProprietarioService proprietarioService;

    public ProprietarioController(ProprietarioService proprietarioService) {
        this.proprietarioService = proprietarioService;
    }

    @GetMapping("/boasVindas")
    public  String boasVindas() {

        return "Essa é minha 1° mensagem nessa rota!";
    }

    //Criar
    @PostMapping("/criar")
    public String criar() {
        return "proprietario criado";
    }


    //listar
    @GetMapping("/listar")
    public List<ProprietarioModel> listarProprietario(){
        return proprietarioService.listaProprietarios();

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

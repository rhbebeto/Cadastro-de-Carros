package com.dev.Cadastro.Proprietarios;

import com.dev.Cadastro.Carros.CarroModel;
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
    public ProprietarioDTO criar(@RequestBody ProprietarioDTO proprietarioDTO){
        return proprietarioService.criarProprietario(proprietarioDTO);
    }

    //Listar todos
    @GetMapping("/listar")
    public List<ProprietarioDTO> listarProprietario(){
        return proprietarioService.listaProprietarios();

    }

    //Listar Por id
    @GetMapping("/listar/{id}")
    public ProprietarioDTO listarPorId(@PathVariable Long id){
        return proprietarioService.listarPorId(id);
    }

    //Alterar
    @PutMapping("/alterar/{id}")
    public ProprietarioDTO alterarProprietarioID(@PathVariable Long id,@RequestBody ProprietarioDTO proprietarioAlterado) {
        return proprietarioService.alterar(id, proprietarioAlterado);
    }

    //deletar
    @DeleteMapping("/deletar/{id}")
    public String deletarId(@PathVariable Long id){
        proprietarioService.deletarProprietario(id);
        return "Deletado com sucesso!";
    }
}

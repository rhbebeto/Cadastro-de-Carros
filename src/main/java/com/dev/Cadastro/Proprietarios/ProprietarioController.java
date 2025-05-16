package com.dev.Cadastro.Proprietarios;

import com.dev.Cadastro.Carros.CarroDTO;
import com.dev.Cadastro.Carros.CarroModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criar(@RequestBody ProprietarioDTO proprietarioDTO){
        ProprietarioDTO proprietraioNovo= proprietarioService.criarProprietario(proprietarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O Proprietário " +proprietraioNovo.getNome()+ "de id" + proprietraioNovo.getId() + " foi criado com sucesso!");
    }

    //Listar todos
    @GetMapping("/listar")
    public List<ProprietarioDTO> listarProprietario(){
        return proprietarioService.listaProprietarios();

    }

    //Listar Por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        ProprietarioDTO proprietario = proprietarioService.listarPorId(id);
        if (proprietario != null){
            return ResponseEntity.ok(proprietario);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado!");
        }
    }

    //Alterar
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarProprietarioID(@PathVariable Long id,@RequestBody ProprietarioDTO proprietarioAlterado) {
        if (proprietarioService.listarPorId(id)!= null) {
            proprietarioService.alterar(id, proprietarioAlterado);
            return ResponseEntity.ok().body("Usuario alterado com sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado.");
        }
    }

    //deletar
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarId(@PathVariable Long id){
        if (proprietarioService.listarPorId(id)!= null) {
            proprietarioService.deletarProprietario(id);
            return ResponseEntity.ok().body("Proprietario excluido com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id não encontrado.");
        }
    }
}

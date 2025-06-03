package com.dev.Cadastro.Carros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carros/ui")
public class CarroControllerUi {
 private final CarroService carroService;

    public CarroControllerUi(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping("/listar")
    public String listarCarro(Model model){
        List<CarroDTO> carros = carroService.listarCarros();
        model.addAttribute("carros", carros);
        return "listarCarros";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCarro(@PathVariable Long id) {
        carroService.deletarCarro( id);
        return "redirect:/carros/ui/listar";
    }

    //Alterar
    @PutMapping("alterar/{id}")
    public String atualizarCarro(@PathVariable Long id, @RequestBody CarroDTO carroDTO) {
        carroService.atualizarCarro(id, carroDTO);
        return "redirect:/carros/ui/listar";
    }

    //Criar
    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionar(Model model) {
       model.addAttribute("carro", new CarroDTO());
        return "criarCarro";
    }
    @PostMapping("/salvar")
    public String salvarCarro(@ModelAttribute CarroDTO carroDTO) {
        carroService.criarCarro(carroDTO);
        return "redirect:/carros/ui/listar";
    }



}

package com.dev.Cadastro.Proprietarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioService {

    private ProprietarioRepository proprietarioRepository;

    public ProprietarioService(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    //Listar todos proprietarios
    public List<ProprietarioModel> listaProprietarios (){
        return proprietarioRepository.findAll();
    }

    //Listar por Id
    public ProprietarioModel listarPorId(Long id){
        Optional<ProprietarioModel> propretarioPorId = proprietarioRepository.findById(id);
        return propretarioPorId.orElse(null);
    }

    //Criar novo propietario
    public ProprietarioModel criarProprietario(ProprietarioModel proprietario){
        return proprietarioRepository.save(proprietario);
    }

}

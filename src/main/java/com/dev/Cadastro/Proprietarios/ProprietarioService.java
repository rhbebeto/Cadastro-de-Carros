package com.dev.Cadastro.Proprietarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprietarioService {

    private ProprietarioRepository proprietarioRepository;

    public ProprietarioService(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    //Listar proprietarios
    public List<ProprietarioModel> listaProprietarios (){

        return proprietarioRepository.findAll();

    }

}

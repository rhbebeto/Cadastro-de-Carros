package com.dev.Cadastro.Proprietarios;

import org.springframework.stereotype.Component;

@Component
public class ProprietarioMapper {
    public ProprietarioModel map(ProprietarioDTO proprietarioDTO){
        ProprietarioModel proprietarioModel = new ProprietarioModel();
        proprietarioModel.setId(proprietarioDTO.getId());
        proprietarioModel.setNome(proprietarioDTO.getNome());
        proprietarioModel.setCpf(proprietarioDTO.getCpf());
        proprietarioModel.setEmail(proprietarioDTO.getEmail());
        proprietarioModel.setTelefone(proprietarioDTO.getTelefone());
        proprietarioModel.setListaCarros(proprietarioDTO.getListaCarros());
        return proprietarioModel;

    }
    public ProprietarioDTO map(ProprietarioModel proprietarioModel){
        ProprietarioDTO proprietarioDTO = new ProprietarioDTO();
        proprietarioDTO.setId(proprietarioModel.getId());
        proprietarioDTO.setNome(proprietarioModel.getNome());
        proprietarioDTO.setCpf(proprietarioModel.getCpf());
        proprietarioDTO.setEmail(proprietarioModel.getEmail());
        proprietarioDTO.setTelefone(proprietarioModel.getTelefone());
        proprietarioDTO.setListaCarros(proprietarioModel.getListaCarros());
        return proprietarioDTO;
    }
}

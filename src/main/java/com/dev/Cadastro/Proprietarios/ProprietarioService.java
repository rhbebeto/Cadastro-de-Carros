package com.dev.Cadastro.Proprietarios;

import com.dev.Cadastro.Carros.CarroMapper;
import com.dev.Cadastro.Carros.CarroModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProprietarioService {

    private ProprietarioRepository proprietarioRepository;
    private ProprietarioMapper proprietarioMapper;

    public ProprietarioService(ProprietarioMapper proprietarioMapper, ProprietarioRepository proprietarioRepository) {
        this.proprietarioMapper = proprietarioMapper;
        this.proprietarioRepository = proprietarioRepository;
    }

    //Listar todos proprietarios
    public List<ProprietarioDTO> listaProprietarios (){
        List<ProprietarioModel> lista = proprietarioRepository.findAll();
        return lista.stream()
                .map(proprietarioMapper::map)
                .collect(Collectors.toList());
    }

    //Listar por Id
    public ProprietarioDTO listarPorId(Long id){
        Optional<ProprietarioModel> propretarioPorId = proprietarioRepository.findById(id);
        return propretarioPorId.map(proprietarioMapper::map).orElse(null);
    }

    //Criar novo propietario
    public ProprietarioDTO criarProprietario(ProprietarioDTO proprietarioDTO){
        ProprietarioModel proprietario = proprietarioMapper.map(proprietarioDTO);
        proprietario = proprietarioRepository.save(proprietario);
        return proprietarioMapper.map(proprietario);
    }

    //Deletar
    public void deletarProprietario(Long id){
        proprietarioRepository.deleteById(id);
    }

    //Alterar
    public ProprietarioDTO alterar(Long id, ProprietarioDTO proprietarioAlterado ){
        Optional<ProprietarioModel> proprietarioExistente = proprietarioRepository.findById(id);
        if (proprietarioExistente.isPresent()){
            ProprietarioModel proprietarioAtualizado = proprietarioMapper.map(proprietarioAlterado);
            proprietarioAtualizado.setId(id);
            ProprietarioModel proprietarioSalvo = proprietarioRepository.save(proprietarioAtualizado);
            return proprietarioMapper.map(proprietarioSalvo);
        }
        return null;
    }

}

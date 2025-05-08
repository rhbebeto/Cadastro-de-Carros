package com.dev.Cadastro.Carros;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    //Listar todos carros
    public List<CarroModel> listarCarros(){
        return carroRepository.findAll();
    }

    //Listar por id
    public CarroModel listarPorId(Long id){
        Optional<CarroModel> carroPorId = carroRepository.findById(id);
        return carroPorId.orElse(null) ;

    }
    //Criar novo Carro
    public CarroModel criarCarro(CarroModel carro){
        return carroRepository.save(carro);
    }

    //Deletar
    public void deletarCarro (Long id){
        carroRepository.deleteById(id);
    }

    //Atualizar
    public CarroModel atualizarCarro (Long id, CarroModel carroAtualizado){
        if (carroRepository.existsById(id)){
            carroAtualizado.setId(id);
            return carroRepository.save(carroAtualizado);
        }
        return null;

    }

}

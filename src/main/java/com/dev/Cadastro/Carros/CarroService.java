package com.dev.Cadastro.Carros;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private CarroRepository carroRepository;
    private CarroMapper carroMapper;

    public CarroService(CarroRepository carroRepository, CarroMapper carroMapper) {
        this.carroRepository = carroRepository;
        this.carroMapper = carroMapper;
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
    public CarroDTO criarCarro(CarroDTO carroDto){
        CarroModel carro = carroMapper.map(carroDto);
        carro = carroRepository.save(carro);
        return carroMapper.map(carro);
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

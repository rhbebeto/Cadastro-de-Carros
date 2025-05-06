package com.dev.Cadastro.Carros;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    private CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    //listar carros
    public List<CarroModel> listarCarros(){
        return carroRepository.findAll();
    }
}

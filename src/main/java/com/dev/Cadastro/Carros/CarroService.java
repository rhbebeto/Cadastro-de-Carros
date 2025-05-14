package com.dev.Cadastro.Carros;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    private CarroRepository carroRepository;
    private CarroMapper carroMapper;

    public CarroService(CarroRepository carroRepository, CarroMapper carroMapper) {
        this.carroRepository = carroRepository;
        this.carroMapper = carroMapper;
    }



    //Listar todos carros
    public List<CarroDTO> listarCarros(){
        List<CarroModel> carros = carroRepository.findAll();
        return carros.stream()
                .map(carroMapper::map)
                .collect(Collectors.toList());

    }

    //Listar por id
    public CarroDTO listarPorId(Long id){
        Optional<CarroModel> carroPorId = carroRepository.findById(id);
        return carroPorId.map(carroMapper::map).orElse(null);

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
    public CarroDTO atualizarCarro (Long id, CarroDTO carroDTO){
        Optional<CarroModel> carroExistente = carroRepository.findById(id);
        if(carroExistente.isPresent()){
            CarroModel carroAtualizado = carroMapper.map(carroDTO);
            carroAtualizado.setId(id);
            CarroModel carroSalvo = carroRepository.save(carroAtualizado);
            return carroMapper.map(carroSalvo);
        }
        return null;

    }

}

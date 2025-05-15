package com.dev.Cadastro.Carros;

import org.springframework.stereotype.Component;

@Component
public class CarroMapper {

    public CarroModel map(CarroDTO carroDTO) {
        CarroModel carroModel = new CarroModel();
        carroModel.setId(carroDTO.getId());
        carroModel.setCor(carroDTO.getCor());
        carroModel.setPlaca(carroDTO.getPlaca());
        carroModel.setMarca(carroDTO.getMarca());
        carroModel.setProprietario(carroDTO.getProprietario());
        carroModel.setModelo(carroDTO.getModelo());
        carroModel.setAnoFabricacao(carroDTO.getAnoFabricacao());
        return carroModel;
    }

    public CarroDTO map(CarroModel carroModel) {
        CarroDTO carroDTO = new CarroDTO();
        carroDTO.setId(carroModel.getId());
        carroDTO.setCor(carroModel.getCor());
        carroDTO.setPlaca(carroModel.getPlaca());
        carroDTO.setMarca(carroModel.getMarca());
        carroDTO.setProprietario(carroModel.getProprietario());
        carroDTO.setModelo(carroModel.getModelo());
        carroDTO.setAnoFabricacao(carroModel.getAnoFabricacao());
        return carroDTO;
    }
}

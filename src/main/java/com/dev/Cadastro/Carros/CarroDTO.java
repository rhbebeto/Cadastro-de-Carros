package com.dev.Cadastro.Carros;

import com.dev.Cadastro.Proprietarios.ProprietarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarroDTO {

    private Long id;
    private String modelo;
    private int anoFabricacao;
    private String marca;
    private String placa;
    private ProprietarioModel proprietario;
    private String cor;

}

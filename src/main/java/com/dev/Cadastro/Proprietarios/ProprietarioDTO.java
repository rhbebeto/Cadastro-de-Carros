package com.dev.Cadastro.Proprietarios;

import com.dev.Cadastro.Carros.CarroModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProprietarioDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    @JsonProperty("listaCarros")
    private List<CarroModel> ListaCarros;
}

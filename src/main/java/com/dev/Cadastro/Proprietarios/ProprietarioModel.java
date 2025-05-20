package com.dev.Cadastro.Proprietarios;

import com.dev.Cadastro.Carros.CarroModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name= "tb_proprietario")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ProprietarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    @OneToMany(mappedBy = "proprietario")
    @JsonIgnore
    @JsonProperty("listaCarros")
    private List<CarroModel> ListaCarros;





}

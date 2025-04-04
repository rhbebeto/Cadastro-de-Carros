package com.dev.Cadastro.Proprietarios;

import com.dev.Cadastro.Carros.CarroModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "tb_proprietario")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProprietarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    @OneToMany(mappedBy = "proprietario")
    private List<CarroModel> ListaCarros;





}

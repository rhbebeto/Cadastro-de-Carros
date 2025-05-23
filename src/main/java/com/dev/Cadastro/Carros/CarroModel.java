package com.dev.Cadastro.Carros;

import com.dev.Cadastro.Proprietarios.ProprietarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "proprietario")
public class CarroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    private int anoFabricacao;

    private String marca;

    @Column(unique = true)
    private String placa;

    @ManyToOne
    @JoinColumn(name = "proprietarios_id") //Foreing Key ou chave estrangeira
    private ProprietarioModel proprietario;

    @Column(name ="cor" )
    private String cor;


}

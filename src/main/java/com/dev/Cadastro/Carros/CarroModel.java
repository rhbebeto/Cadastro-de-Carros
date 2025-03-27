package com.dev.Cadastro.Carros;

import com.dev.Cadastro.Proprietarios.ProprietarioModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
public class CarroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private int anoFabricacao;
    private String marca;
    private String placa;
    @ManyToOne
    @JoinColumn(name = "proprietarios_id") //Foreing Key ou chave estrangeira
    private ProprietarioModel proprietario;

    public CarroModel(){
    }

    public CarroModel(String modelo, int anoFabricacao, String marca, String placa) {
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.marca = marca;
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {return placa;}

    public void setPlaca(String placa) {this.placa = placa; }
}

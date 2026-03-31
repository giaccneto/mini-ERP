package com.giaccneto.mini_ERP.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeMedicamento;
    private String laboratorio;
    private String descricaoMedicamento;
    private int quantidadeEstoque;
    private double preco;
    private LocalDate dataValidade;


    public Medicamento(Long id, String nomeMedicamento, String laboratorio, String descricaoMedicamento, int quantidadeEstoque, double preco, LocalDate dataValidade) {
        this.id = id;
        this.nomeMedicamento = nomeMedicamento;
        this.laboratorio = laboratorio;
        this.descricaoMedicamento = descricaoMedicamento;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public Medicamento() {
    }

    public Long getId() {
        return id;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getDescricaoMedicamento() {
        return descricaoMedicamento;
    }

    public void setDescricaoMedicamento(String descricaoMedicamento) {
        this.descricaoMedicamento = descricaoMedicamento;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}

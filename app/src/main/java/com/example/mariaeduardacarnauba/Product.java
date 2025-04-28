package com.example.mariaeduardacarnauba;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nomeProd;
    private String codProd;
    private Double preco;
    private Integer qtdEstoque;

    public Product(String nomeProd, String codProd, Double preco, Integer qtdEstoque){
        this.nomeProd = nomeProd;
        this.codProd = codProd;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNomeProd() { return nomeProd; }
    public String getCodProd() { return codProd; }
    public Double getPreco() { return preco; }
    public Integer getQtdEstoque() { return qtdEstoque; }
}

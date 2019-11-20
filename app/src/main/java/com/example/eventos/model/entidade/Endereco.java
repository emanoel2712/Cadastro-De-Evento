package com.example.eventos.model.entidade;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@DatabaseTable
public class Endereco implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

    @DatabaseField(columnName = "estado", canBeNull = true)
    private String estado;

    @DatabaseField(columnName = "cidade", canBeNull = true)
    private String cidade;

    @DatabaseField(columnName = "bairro", canBeNull = true)
    private String bairro;

    @DatabaseField(columnName = "cep", canBeNull = true)
    private String cep;

    @DatabaseField(columnName = "logradouro")
    private String logradouro;

    @DatabaseField(columnName = "numero")
    private String numero;

    public Endereco() {
    }


    public Endereco(Integer id, String estado, String cidade, String bairro, String cep, String logradouro, String numero) {
        this.id = id;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


}



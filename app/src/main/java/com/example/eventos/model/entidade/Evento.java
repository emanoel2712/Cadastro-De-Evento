package com.example.eventos.model.entidade;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

@DatabaseTable
public class Evento implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

    @DatabaseField(columnName = "nome", canBeNull = false, width = 60)
    private String nome;

    @DatabaseField(columnName = "data", canBeNull = true)
    private String data;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Endereco endereco;


    public Evento() {
        this.endereco = new Endereco();


    }

    public Evento(Integer id, String nome, String data) {
        this.id = id;
        this.nome = nome;
        this.data = data;

        this.endereco = new Endereco();



    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setData(String data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return " Nome do evento: " + nome + "\n" +
                " Data=" + data + "\n" +
                " Estado: " + endereco.getEstado() + "\n" +
                " Cidade: " + endereco.getCidade() + "\n" +
                " Bairro: " + endereco.getBairro() + "\n" +
                " Logradouro: " + endereco.getLogradouro() + "\n" +
                " Cep: " + endereco.getCep() + "\n" +
                " Número: " + endereco.getNumero();
    }
//
//    @Override
//    public String toString() {
//        return "Evento{" +
//                "id=" + id +
//                ", nome='" + nome + '\'' +
//                ", data=" + data +
//                ", endereco=" + endereco
//                ;
//    }
}


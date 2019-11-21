package com.example.eventos.model.DTO;

import com.example.eventos.model.entidade.Endereco;
import com.example.eventos.model.entidade.Evento;

import java.util.Date;

public class EventoDTO {
    private Integer id;
    private String nome;
    private String data;
    private EnderecoDTO endereco;


    public EventoDTO() {


    }

    public EventoDTO(Integer id, String nome, String data, EnderecoDTO endereco) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.endereco = endereco;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setData(String data) {
        this.data = data;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }


    public Evento getEvento() {
        Evento e = new Evento();
        e.setId(id);
        e.setNome(nome);
        e.setData(data);
        e.setEndereco(endereco.getEndereco());
//        e.getEndereco().setLogradouro(endereco.getLogradouro());
//        e.getEndereco().setEstado(endereco.getEstado());
//        e.getEndereco().setCidade(endereco.getCidade());
//        e.getEndereco().setNumero(endereco.getNumero());
//        e.getEndereco().setCep(endereco.getCep());
//        e.getEndereco().setBairro(endereco.getBairro());

        return e;
    }


}

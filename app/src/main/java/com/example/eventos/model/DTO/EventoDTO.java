package com.example.eventos.model.DTO;

import com.example.eventos.model.entidade.Endereco;
import com.example.eventos.model.entidade.Evento;

import java.util.Date;

public class EventoDTO {
    private Integer id;
    private String nome;
    private Date data;
    private EnderecoDTO endereco;
    private FotoDTO foto;

    public EventoDTO() {
        endereco = new EnderecoDTO();
        foto = new FotoDTO();
    }

    public EventoDTO(Integer id, String nome, Date data) {
        this.id = id;
        this.nome = nome;
        this.data = data;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public FotoDTO getFoto() {
        return foto;
    }

    public void setFoto(FotoDTO foto) {
        this.foto = foto;
    }

    public Evento getEvento() {
        Evento e = new Evento();
        e.setId(id);
        e.setNome(nome);
        e.setData(data);
        e.setEndereco(endereco.getEndereco());
        e.setFoto(foto.getFoto());

        return e;
    }


}

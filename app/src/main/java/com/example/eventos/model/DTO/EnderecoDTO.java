package com.example.eventos.model.DTO;

import com.example.eventos.model.entidade.Endereco;

public class EnderecoDTO {
    private Integer id;
    private String estado;
    private String cidade;
    private String bairro;
    private String cep;
    private String logradouro;
    private String numero;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Integer id, String estado, String cidade, String bairro, String cep, String logradouro, String numero) {
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
    

    public Endereco getEndereco() {
        Endereco e = new Endereco();
        e.setId(id);
        e.setEstado(estado);
        e.setCidade(cidade);
        e.setBairro(bairro);
        e.setCep(cep);
        e.setLogradouro(logradouro);
        e.setNumero(numero);

        return e;
    }
}
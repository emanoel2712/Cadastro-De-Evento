package com.example.eventos.model.DTO;

import com.example.eventos.model.entidade.Foto;

public class FotoDTO {
    private Integer id;
    private String caminho;

    public FotoDTO() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Foto getFoto(){
        Foto f = new Foto();
        f.setId(id);
        f.setCaminho(caminho);
        return f;
    }
}

package com.example.eventos.model.DTO;

import com.example.eventos.model.entidade.Foto;

public class FotoDTO {
    private String caminho;

    public FotoDTO() {
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Foto getFoto(){
        Foto f = new Foto();
        f.setCaminho(caminho);
        return f;
    }
}

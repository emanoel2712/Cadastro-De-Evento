package com.example.eventos.model.dao;

import android.content.Context;

import com.example.eventos.model.dao.helpers.DaoHelper;
import com.example.eventos.model.entidade.Endereco;



public class EnderecoDao extends DaoHelper<Endereco> {
    public EnderecoDao(Context c) {
        super(c, Endereco.class);
    }


}

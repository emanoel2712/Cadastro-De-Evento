package com.example.eventos.model.dao;

import android.content.Context;

import com.example.eventos.model.dao.helpers.DaoHelper;
import com.example.eventos.model.entidade.Foto;

public class FotoDao extends DaoHelper<Foto> {
    public FotoDao(Context c) {
        super(c, Foto.class);
    }

}



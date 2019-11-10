package com.example.eventos.dao;

import android.content.Context;

import com.example.eventos.dao.helpers.DaoHelper;
import com.example.eventos.model.entidade.Foto;

public class FotoDao extends DaoHelper<Foto> {
    public FotoDao(Context c) {
        super(c, Foto.class);
    }

}



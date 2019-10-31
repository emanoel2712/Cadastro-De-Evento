package com.example.eventos.model.dao;

import android.content.Context;

import com.example.eventos.model.dao.helpers.DaoHelper;
import com.example.eventos.model.entidade.Evento;



public class EventoDao extends DaoHelper<Evento> {
    public EventoDao(Context c) {
        super(c, Evento.class);
    }
}

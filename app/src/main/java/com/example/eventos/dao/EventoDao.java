package com.example.eventos.dao;

import android.content.Context;

import com.example.eventos.dao.helpers.DaoHelper;
import com.example.eventos.model.entidade.Evento;


public class EventoDao extends DaoHelper<Evento> {
    public EventoDao(Context c) {
        super(c, Evento.class);
    }
}










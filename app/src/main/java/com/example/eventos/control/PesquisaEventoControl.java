package com.example.eventos.control;

import android.app.Activity;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eventos.R;
import com.example.eventos.dao.EnderecoDao;
import com.example.eventos.dao.EventoDao;
import com.example.eventos.model.DTO.EventoDTO;

import com.example.eventos.model.entidade.Endereco;
import com.example.eventos.model.entidade.Evento;
import com.example.eventos.util.Constantes;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PesquisaEventoControl {
    private Activity activity;

    private ListView lvEventos;
    private ArrayAdapter<Evento> adapterEventos;
    private List<Evento> listEvento;
    private EventoDao eventoDao;
    private Evento evento;

     private EnderecoDao enderecoDao;
     private Endereco endereco;

    public PesquisaEventoControl(Activity activity) {
        this.activity = activity;

        evento = new Evento();

        eventoDao = new EventoDao(activity);

        evento = (Evento) activity.getIntent().getSerializableExtra(Constantes.PARAM_EVENTO);

        initComponents();

//        carregarEventos();
    }

    private void initComponents() {
        lvEventos = activity.findViewById(R.id.lvEventos);
        configListViewEvento();
//        carregarEventos();
    }
//
    public void carregarEventos() {
        AsyncHttpClient client = new AsyncHttpClient();
        String URL = "http://192.168.0.21:8080/GerenciarEventoWebService/api/evento";
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciando requisição", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
                Toast.makeText(activity, "Tentativa " + retryNo, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes) {
                String eventoJSON = new String(bytes);
                Gson gson = new Gson();

                //Converte o texto json para objeto
                EventoDTO eDTO = gson.fromJson(eventoJSON, EventoDTO.class);

                //Transforma o EventoDTO da API no Evento do projeto
                Evento e = eDTO.getEvento();
//                carregarListView(e);
//                configListViewEvento();
            }

            @Override
            public void onFailure(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Falhou.", Toast.LENGTH_SHORT).show();
            }


        });

    }


    public void configListViewEvento() {
//        listComanda = new ArrayList<>();

        try {
            listEvento = eventoDao.getDao().queryForAll();
        } catch (SQLException e) {
            listEvento = new ArrayList<>();
        }


        adapterEventos = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, listEvento);

        lvEventos.setAdapter(adapterEventos);

    }




    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == activity.RESULT_OK) {
            if (requestCode == Constantes.REQUEST_EVENTO) {
                Evento evento = (Evento) data.getSerializableExtra(Constantes.PARAM_EVENTO);

                adapterEventos.add(evento);
                adapterEventos.notifyDataSetChanged();
            }
        }
    }


}



package com.example.eventos.control;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import android.widget.EditText;
import android.widget.Toast;

import com.example.eventos.R;
import com.example.eventos.dao.EnderecoDao;
import com.example.eventos.dao.EventoDao;

import com.example.eventos.model.entidade.Endereco;
import com.example.eventos.model.entidade.Evento;
import com.example.eventos.util.Constantes;
import com.example.eventos.view.PesquisaEventoActivity;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.File;
import java.sql.SQLException;

import cz.msebera.android.httpclient.Header;

public class MainControl {
    private Activity activity;
    private EditText editNome;
    private EditText editData;
    private EditText editEstado;
    private EditText editCidade;
    private EditText editBairro;
    private EditText editLogradouro;
    private EditText editCep;
    private EditText editNumero;


    private EventoDao eventoDao;
    private EnderecoDao enderecoDao;
    private Evento evento;


    public MainControl(Activity activity) {
        this.activity = activity;

        this.enderecoDao = new EnderecoDao(activity);
        this.eventoDao = new EventoDao(activity);

        initComponents();


    }

    private void initComponents() {
        editNome = activity.findViewById(R.id.editNome);
        editData = activity.findViewById(R.id.editData);
        editEstado = activity.findViewById(R.id.editEstado);
        editCidade = activity.findViewById(R.id.editCidade);
        editBairro = activity.findViewById(R.id.editBairro);
        editCep = activity.findViewById(R.id.editCep);
        editLogradouro = activity.findViewById(R.id.editLogradouro);
        editNumero = activity.findViewById(R.id.editNumero);


    }

    public void cadastroPostEvento() {

        evento = getDadosForm();

        Gson gson = new Gson();

        RequestParams dado = new RequestParams("dado", gson.toJson(evento));

        AsyncHttpClient client = new AsyncHttpClient();
        String URL = "http://10.10.164.223:8080/GerenciarEventoWebService/api/evento";
        client.post(URL, dado, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciando requisição", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);

            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                try {
                    eventoDao.getDao().create(evento);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(activity, "Requisição Bem Sucedida", Toast.LENGTH_LONG).show();

                Intent it = new Intent(activity, PesquisaEventoActivity.class);
//                it.putExtra(Constantes.PARAM_EVENTO, e);
                activity.startActivity(it);

            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Erro na requisição", Toast.LENGTH_LONG).show();
            }


        });


    }


    private Evento getDadosForm() {
        Evento evento = new Evento();


        evento.setNome(editNome.getText().toString());
        evento.setData(editData.getText().toString());


        evento.setEndereco(new Endereco());
        evento.getEndereco().setEstado(editEstado.getText().toString());
        evento.getEndereco().setCidade(editCidade.getText().toString());
        evento.getEndereco().setBairro(editBairro.getText().toString());
        evento.getEndereco().setCep(editCep.getText().toString());
        evento.getEndereco().setLogradouro(editLogradouro.getText().toString());
        evento.getEndereco().setNumero(editNumero.getText().toString());

//        Endereco e = new Endereco();
//
//        e.setEstado(editEstado.getText().toString());
//        e.setCidade(editCidade.getText().toString());
//        e.setBairro(editBairro.getText().toString());
//        e.setCep(editCep.getText().toString());
//        e.setLogradouro(editLogradouro.getText().toString());
//        e.setNumero(editNumero.getText().toString());

//        evento.setEndereco(e);

//        evento.setEndereco(e);

//        evento.setFoto(new Foto());
//        Foto foto = new Foto();
//        foto.setCaminho(editFt.getText().toString());
//        evento.setFoto(foto)


//            e.getFoto().setCaminho(mFilePathCallback.toString());
//            e.getFoto().setCaminho(imagemSelecionada.toString());
//        listComanda.add(comanda);
        return evento;
    }

    public void salvarEventoAction() {
        Evento e = getDadosForm();

        try {
//            if (eventoDao.getDao().createIfNotExists(e) > 0){
            if (eventoDao.getDao().create(e) > 0) {

                Intent it = new Intent(activity, PesquisaEventoActivity.class);
                it.putExtra(Constantes.PARAM_EVENTO, e);
                activity.startActivity(it);


//                    Intent it = new Intent(activity, PesquisaEventoActivity.class);
//                    activity.setResult(activity.RESULT_OK, it);
//                    activity.startActivity(it);*/
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}




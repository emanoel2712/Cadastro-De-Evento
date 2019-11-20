package com.example.eventos.view;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.eventos.R;
import com.example.eventos.control.PesquisaEventoControl;

public class PesquisaEventoActivity extends Activity {
    private PesquisaEventoControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_evento);
        control = new PesquisaEventoControl(this);
        control.carregarEventos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        control.configListViewEvento();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }
}

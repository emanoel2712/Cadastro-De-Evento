package com.example.eventos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.eventos.R;
import com.example.eventos.control.PesquisaEventoControl;

public class PesquisaEventoActivity extends AppCompatActivity {
    private PesquisaEventoControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_evento);
        control = new PesquisaEventoControl(this);
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

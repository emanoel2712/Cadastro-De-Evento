package com.example.eventos.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



import com.example.eventos.R;
import com.example.eventos.control.MainControl;

public class MainActivity extends Activity {
    private MainControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }


    public void salvarAction(View v) {
        control.cadastroPostEvento();
    }



}



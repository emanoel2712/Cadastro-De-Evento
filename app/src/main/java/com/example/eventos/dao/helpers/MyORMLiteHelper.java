package com.example.eventos.dao.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.eventos.model.entidade.Endereco;
import com.example.eventos.model.entidade.Evento;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;


public class MyORMLiteHelper extends OrmLiteSqliteOpenHelper{
    private static final String DATABASE_NAME = "gerenciareventoss";
    private static final int DATABASE_VERSION = 3;
    public MyORMLiteHelper(Context c){
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Evento.class);
            TableUtils.createTable(connectionSource, Endereco.class);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Evento.class, true);
            TableUtils.dropTable(connectionSource, Endereco.class, true);

            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
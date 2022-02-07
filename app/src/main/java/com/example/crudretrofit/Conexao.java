package com.example.crudretrofit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {
    //criar banco
    private static  final String nome = "bancoCEP.db";
    //dizerndo que esta é sua primeira versão
    private static  final int version =1 ;




    //aplicando um contexto para meu db
    public Conexao(Context context){
        super(context , nome, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //nesta linha criamos uma tabela que contem os sequintes valores
        //smpre ter um id pois ele se auto incrementa
        db.execSQL("create table cep(id integer primary key autoincrement,"+
                "cep varchar(50)" +
                ",logradouro varchar(50)" +
                ",complemento varchar(50) " +
                ",bairro varchar(50)" +
                ",ibge varchar(50)" +
                ",ddd varchar(50)" +
                ",localidade varchar(50)" +
                " ,uf varchar(50))");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.crudretrofit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CEPDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;


    public CEPDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();

    }


    public long inserir(CEP cep) {
        ContentValues values = new ContentValues();
        values.put("cep", cep.getCep());
        return banco.insert("cep", null, values);


    }



    public List<CEP> obterTodos(){
        List <CEP> ceps = new ArrayList<>();
        //fazendo uma consulta no banco de dados na tabela "cep onde deve possuir essas variaveis de armazenamento


        Cursor cursor = banco.query("ceps" , new String[]{"id", "cep"},
                null, null, null, null, null);

        //varendo a lista vetor até o fim
        while(cursor.moveToNext()){
            CEP c = new CEP();
            c.setId(cursor.getInt(0));
            c.setCep(cursor.getString(1));




        }
    return ceps;
    }

    public void excluir(CEP c){
        banco.delete("cep", "id = ? ", new String[]{
                c.getId().toString()
        });
    }

    public void atualizar(CEP cep){
        ContentValues values = new ContentValues();
        values.put("cep", cep.getCep());

    }



}

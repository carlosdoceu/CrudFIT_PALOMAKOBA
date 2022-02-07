package com.example.crudretrofit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListarCEP extends AppCompatActivity {

    private ListView listViewCEP;
    private CEPDAO dao;
    private List<CEP> ceps;
    private List<CEP> cepsFiltrados = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_cep);



    listViewCEP = findViewById(R.id.listView_CEP);
    dao = new CEPDAO(this);


    //nessa linha iremos usar o dao para chamar cepdao para poder ter seus metodos
        ceps = dao.obterTodos();
        cepsFiltrados.addAll(ceps);
    //precisamos de um adaptador e para um adaptador precisamos de um contexto

        CEPAdapter adaptador = new CEPAdapter(this, cepsFiltrados);

        listViewCEP.setAdapter(adaptador);
        registerForContextMenu(listViewCEP);


    }

    public void cadastrar(MenuItem mi) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }

    //metodos para consulta
    public void procurarCEP(String cepDigitado){
        cepsFiltrados.clear();
        for (CEP c : ceps){
            if(c.getCep().toLowerCase().contains(cepDigitado.toLowerCase())){

            }

        }
        listViewCEP.invalidateViews();
    }




    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);
        SearchView sv = (SearchView) menu.findItem(R.id.txtPesquisar).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                procurarCEP(s);
                return false;
            }
        });



        return  true;
    }

    //esse metodo fará com que ao clicar e precionar um nome da lista apareçam opções de modificações
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_contexto, menu);


    }


    public void excluir(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final CEP cepExcluir = cepsFiltrados.get(menuInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Deseja excluir aluno")
                .setNegativeButton("Não", null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cepsFiltrados.remove(cepExcluir);
                        ceps.remove(cepExcluir);
                        dao.excluir(cepExcluir);
                        listViewCEP.invalidateViews();
                    }
                }).create();
        dialog.show();
    }

    public void atualizar(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final CEP cepAtualizar = cepsFiltrados.get(menuInfo.position);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("cep",cepAtualizar);
        startActivity(intent);



    }

    public void onResume() {
        super.onResume();
        ceps = dao.obterTodos();
        cepsFiltrados.clear();
        cepsFiltrados.addAll(ceps);
        listViewCEP.invalidateViews();
    }




}
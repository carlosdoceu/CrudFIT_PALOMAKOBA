package com.example.crudretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText editCEP;
    private Button btnmainSalvarCEP;
    private CEP cep = null;
    private CEPDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCEP = findViewById(R.id.editmain_CEP);
        btnmainSalvarCEP = findViewById(R.id.btnmain_SalvarCEP);

        //a mascara do cep
        editCEP.addTextChangedListener(MaskEditUtils.mask(editCEP, MaskEditUtils.FORMAT_CEP));


        //recebe as informações
        Intent it = getIntent();
        if (it.hasExtra("cep")) {
            cep = (CEP) it.getSerializableExtra("cep");
            editCEP.setText(cep.getCep());

        }

        btnmainSalvarCEP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }


        });

    }


    // fazer um salvar que ja faz direto a consulta utilizando retrofit para evitar um novo item no botão
    //fazer a consulta
    public void salvar(View v) {
        if (cep == null) {
            cep = new CEP();
            cep.setCep(editCEP.getText().toString());

            long id = dao.inserir(cep);

            Toast.makeText(this, "Cadastro Inserido com Id:" + id, Toast.LENGTH_SHORT).show();


        } else {

            cep.setCep(editCEP.getText().toString());

            dao.atualizar(cep);
            Toast.makeText(this, "Cadastro Alterado", Toast.LENGTH_SHORT).show();

        }

        Intent intent = new Intent(this, ListarCEP.class);
        startActivity(intent);
        finish();


    }




}
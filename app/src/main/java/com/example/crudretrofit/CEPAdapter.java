package com.example.crudretrofit;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CEPAdapter extends BaseAdapter {
    private List<CEP> ceps;
    private Activity activity;


    public CEPAdapter(Activity activity , List<CEP> ceps){
        this.activity = activity;
        this.ceps = ceps;
    }

    @Override
    public int getCount() {
        return ceps.size();
    }

    @Override
    public Object getItem(int i) {
        return ceps.get(i);

    }

    @Override
    public long getItemId(int i) {
        return ceps.get(i).getId();
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = activity.getLayoutInflater().inflate(R.layout.item,viewGroup, false );
        TextView cep = v.findViewById(R.id.txtitem_CEP);
        TextView logradouro = v.findViewById(R.id.txtitem_Logradouro);
        TextView complemento = v.findViewById(R.id.txtitem_Complemento);
        TextView bairro = v.findViewById(R.id.txtitem_Bairro);
        TextView ibge = v.findViewById(R.id.txtitem_IBGE);
        TextView ddd = v.findViewById(R.id.txtitem_DDD);
        TextView localidade = v.findViewById(R.id.txtitem_Localidade);
        TextView uf = v.findViewById(R.id.txtitem_UF);


        CEP c = ceps.get(i);
        cep.setText(c.getCep());
        logradouro.setText(c.getLogradouro());
        complemento.setText(c.getComplemento());
        bairro.setText(c.getBairro());
        ibge.setText(c.getIbge());
        ddd.setText(c.getDdd());
        localidade.setText(c.getLocalidade());
        uf.setText(c.getUf());

        return  v;

    }
}

package com.example.crudretrofit;

import java.io.Serializable;

public class CEP implements Serializable {
    private Integer id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String ibge;
    private String ddd;
    private String localidade;
    private String uf;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }


    @Override
    public String toString() {
        return "CEP='" + cep +
                " \nLogradouro='" + logradouro +
                " \nBomplemento='" + complemento +
                " \nBairro='" + bairro +
                " \nIBGE='" + ibge +
                " \nDDD='" + ddd +
                " \nLocalidade='" + localidade +
                " \nUF='" + uf;
    }
}

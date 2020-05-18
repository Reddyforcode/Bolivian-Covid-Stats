package com.reddy.retrofitjava.model.covidJsonHelpers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.reddy.retrofitjava.model.covidJsonHelpers.Contador_____;
import com.reddy.retrofitjava.model.covidJsonHelpers.Porcentaje_____;

public class Tj {

    @SerializedName("contador")
    @Expose
    private Contador_____ contador;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("porcentaje")
    @Expose
    private Porcentaje_____ porcentaje;

    public Contador_____ getContador() {
        return contador;
    }

    public void setContador(Contador_____ contador) {
        this.contador = contador;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Porcentaje_____ getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Porcentaje_____ porcentaje) {
        this.porcentaje = porcentaje;
    }

}

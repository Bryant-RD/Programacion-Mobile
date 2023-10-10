package com.example.primerparcial.Entitys;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductSingle implements Serializable {

    @SerializedName("data")
    public Producto data;

    public ProductSingle(Producto data) {
        this.data = data;
    }

    public Producto getData() {
        return data;
    }
}

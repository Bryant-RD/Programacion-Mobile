package com.example.primerparcial.api;


import com.example.primerparcial.Entitys.ProductList;
import com.example.primerparcial.Entitys.ProductSingle;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("/products")
    Call<ProductList> findAll();

    @GET("/products/{id}")
    Call<ProductSingle> find(@Path("id") int id);


}

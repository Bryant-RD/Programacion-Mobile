package com.example.primerparcial.data;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.primerparcial.Entitys.ProductList;
import com.example.primerparcial.Entitys.Producto;
import com.example.primerparcial.api.APIClient;
import com.example.primerparcial.api.APIInterface;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {
    private MutableLiveData<List<Producto>> usersLiveData = new MutableLiveData<>();
    private final APIInterface api;

    ProductRepository(Application application){
        api = APIClient.getClient().create(APIInterface.class);
        api.findAll().enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {

                if (response.isSuccessful()) {
                    ProductList productList = response.body();
                    List<Producto> productos = productList.getData();
                    usersLiveData.setValue(productos);

                    // Imprimir la respuesta JSON
                    String jsonResponse = new Gson().toJson(productList);
                    Log.d("JSON Response", jsonResponse);

                    // Resto de la lógica
                } else {
                    Log.e("API Error", "Error en la solicitud");
                }
            }
//                Log.w("onResponse", "OK!");
//                usersLiveData.setValue(response.body().getData());
//            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Log.w("onFailure", t.getMessage());
                call.cancel();
            }
        });
    }


    public MutableLiveData<List<Producto>> getUsersLiveData() {
        return usersLiveData;
    }
}

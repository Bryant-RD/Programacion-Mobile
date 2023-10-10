package com.example.primerparcial;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primerparcial.Adapters.RefroitAdapter;
import com.example.primerparcial.Entitys.ProductSingle;
import com.example.primerparcial.api.APIClient;
import com.example.primerparcial.api.APIInterface;
import com.example.primerparcial.data.productViewModel;
import com.example.primerparcial.databinding.ActivityMainBinding;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private productViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int spanCount = 1;

        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 2;
        }

        RecyclerView recyclerView = binding.recycler;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), spanCount));
        RefroitAdapter adapter = new RefroitAdapter(new RefroitAdapter.Diff());
        recyclerView.setAdapter(adapter);

        productViewModel = new ViewModelProvider(this).get(productViewModel.class);

        productViewModel.getUsersLiveData().observe(this, products -> {
            adapter.submitList(products);
        });

        APIInterface api = APIClient.getClient().create(APIInterface.class);

        api.find(2).enqueue(new Callback<ProductSingle>() {
            @Override
            public void onResponse(Call<ProductSingle> call, Response<ProductSingle> response) {
//                Log.w("onResponse", response.body().getData().toString());
            }

            @Override
            public void onFailure(Call<ProductSingle> call, Throwable t) {
                Log.w("onFailure", t.getLocalizedMessage());
                call.cancel();
            }
        });

    }
}
package com.example.primerparcial.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.primerparcial.Entitys.Producto;

import java.util.List;

public class productViewModel extends AndroidViewModel {

    private ProductRepository mRepository;

    private MutableLiveData<List<Producto>> usersLiveData;

    public productViewModel(Application application) {
        super(application);
        //super();
        mRepository = new ProductRepository(application);
        usersLiveData = mRepository.getUsersLiveData();
    }

    public MutableLiveData<List<Producto>> getUsersLiveData() {
        return usersLiveData;
    }
}
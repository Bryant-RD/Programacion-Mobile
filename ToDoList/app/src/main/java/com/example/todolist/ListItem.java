package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.todolist.Entitys.TaskRepository;

public class ListItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        Button btnDelete = (Button) findViewById(R.id.btnEliminar);

        btnDelete.setOnClickListener(this::deleteTask);


    }


    public void deleteTask(View v) {
//        TaskRepository.getInstace().deleteTask();
        System.out.println("TEST");
    }

}
package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.todolist.Entitys.Task;
import com.example.todolist.Entitys.TaskRepository;

public class TaskFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Button btnSaveTask = (Button)findViewById(R.id.btnSave);

        btnSaveTask.setOnClickListener(this::saveTask);

    }


    public void saveTask(View v) {

        EditText titulo = (EditText) findViewById(R.id.txtTitulo);
        EditText descripcion = (EditText) findViewById(R.id.txtDescription);

        Task task = new Task(titulo.getText().toString(), descripcion.getText().toString(), false);
        TaskRepository.getInstace().AddListViewTask(task);

        Intent intent = new Intent(TaskFormActivity.this, ListViewActivity.class);
        startActivity(intent);

    }


}
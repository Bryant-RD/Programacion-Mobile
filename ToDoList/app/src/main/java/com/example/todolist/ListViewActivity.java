package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.todolist.Entitys.Task;
import com.example.todolist.Entitys.TaskListAdapter;
import com.example.todolist.Entitys.TaskRepository;

import java.util.*;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = findViewById(R.id.listView);
        List<Task> tasks = TaskRepository.getInstace().getListViewTasks();

        TaskListAdapter adapter = new TaskListAdapter(this, R.layout.activity_list_item, tasks);
        listView.setAdapter(adapter);

        Button btnFormAddTask = (Button) findViewById(R.id.btnAddTask);

        btnFormAddTask.setOnClickListener(this::AddTasForm);


    }

    public void AddTasForm(View v) {
        Intent intent = new Intent(ListViewActivity.this, TaskFormActivity.class);
        startActivity(intent);
    }
}
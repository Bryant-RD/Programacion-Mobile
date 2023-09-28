package com.example.todolist.Entitys;

import java.util.ArrayList;

public class TaskRepository {

    private ArrayList<Task> listViewTasks;
    private ArrayList<Task> recicleViewTasks;
    public static TaskRepository taskRepository = null;

    public TaskRepository() {
        listViewTasks = new ArrayList<>();
        recicleViewTasks = new ArrayList<>();
    }

    public static TaskRepository getInstace() {
        if(taskRepository == null) {
            taskRepository = new TaskRepository();
        }
        return taskRepository;
    }

    public ArrayList<Task> getListViewTasks() {
        return listViewTasks;
    }

    public void AddListViewTask(Task task) {
        listViewTasks.add(task);

    }

    public void deleteTask(Task task) {
        listViewTasks.remove(task);
    }

}

package com.example.todolist.Entitys;

import java.util.UUID;

public class Task {

    private String id;
    private String title;
    private String content;
    private Boolean isCompleted;

    public Task(){};

    public Task(String title, String content, Boolean isCompleted) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.isCompleted = isCompleted;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}

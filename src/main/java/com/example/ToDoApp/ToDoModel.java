package com.example.ToDoApp;

public class ToDoModel {

    String detail;
    String category;
    String due_date;

    public ToDoModel(String detail, String category, String due_date) {
        this.detail = detail;
        this.category = category;
        this.due_date = due_date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDoModel)) return false;
        ToDoModel that = (ToDoModel) o;
        return detail.equals(that.detail);
    }

}

package com.productname.models;

public class Person {
    private int userId;
    private int id;
    private String title;
    private String body;


    public Person() {

    }

    public Person(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Person{" +
            "userId=" + userId +
            ", id=" + id +
            ", title='" + title + '\'' +
            ", body='" + body + '\'' +
            '}';
    }
}

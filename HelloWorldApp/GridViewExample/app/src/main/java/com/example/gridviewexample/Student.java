package com.example.gridviewexample;

public class Student {
    int imageId;
    String name;
    public Student(int imgId, String n ){
        imageId=imgId;
        name=n;
    }

    public int getImageId() {
        return imageId;
    }
    public void setImageId(int id){
        imageId=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }
}

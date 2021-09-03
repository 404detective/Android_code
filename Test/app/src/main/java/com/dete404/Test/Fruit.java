package com.dete404.Test;

public class Fruit {
    private String name;
    private int img_id;

    public Fruit(String name,int img_id){
        this.name=name;
        this.img_id=img_id;
    }

    public String getName(){
        return name;
    }

    public int getImg_id(){
        return img_id;
    }
}

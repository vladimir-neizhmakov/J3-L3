package com.geekbrains.spring.mvc.model;

public class Product {
    private static int iid=0;
    private int id;
    private String title;
    private int cost;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Product(String title, int cost) {
        iid++;
        this.id = iid;
        this.title = title;
        this.cost = cost;
    }

 //   @Override
 //   public String toString(){return String.format("Product:  [ID:%d TITLE:%s COST:%d]\n", id, title, cost);}


}

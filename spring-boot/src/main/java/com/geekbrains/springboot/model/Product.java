package com.geekbrains.springboot.model;

public class Product {
    private Long id;
    private String title;
    private Float coast;

    public Product(Long id, String title, Float coast) {
        this.id = id;
        this.title = title;
        this.coast = coast;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCoast() {
        return coast;
    }

    public void setCoast(Float coast) {
        this.coast = coast;
    }
}

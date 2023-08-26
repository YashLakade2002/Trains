package com.geektrust.backend.entities;

public class Boggie extends BaseEntity{
    private final String name;

    public Boggie(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

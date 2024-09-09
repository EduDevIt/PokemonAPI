package com.train.Api.pokemon;

public class Pokemon {
    private String name;
    private String id;
    private String type1;
    private String type2;

    // Constructor
    public Pokemon(String name, String id, String type1, String type2) {
        this.name = name;
        this.id = id;
        this.type1 = type1;
        this.type2 = type2;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    @Override
    public String toString() {
        if (type2.isEmpty()) {

            return "ID = " + id + ", " + name + ". Type 1: " + type1.toLowerCase();
        } else {

            return "ID = " + id + ", " + name + ". Type 1: " + type1.toLowerCase() + " | Type 2: " + type2.toLowerCase();
        }
    }

}

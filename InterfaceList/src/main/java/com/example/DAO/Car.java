package com.example.DAO;

public class Car {


    private String model;
    private String version;

    public Car(){

    }
    public Car(String model, String version){

        this.model = model;
        this.version = version;

    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}

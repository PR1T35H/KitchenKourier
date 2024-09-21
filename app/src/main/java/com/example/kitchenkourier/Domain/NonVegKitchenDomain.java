package com.example.kitchenkourier.Domain;

import java.io.Serializable;

public class NonVegKitchenDomain implements Serializable {
    private String title;
    private String pic;
    private Double fee;
    private int numberInCar;

    public NonVegKitchenDomain(String title, String pic, Double fee) {
        this.title = title;
        this.pic = pic;

        this.fee = fee;
    }

    public NonVegKitchenDomain(String title, String pic, Double fee, int numberInCar) {
        this.title = title;
        this.pic = pic;
        this.fee = fee;
        this.numberInCar = numberInCar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberInCar() {
        return numberInCar;
    }

    public void setNumberInCar(int numberInCar) {
        this.numberInCar = numberInCar;
    }
}


package com.productname.models;

import java.util.Objects;

public class CarDto {

    private int wheelsNumber;
    private String manufacturer;
    private String model;


    public CarDto(String manufacturer, String model, int wheelsNumber) {
        this.wheelsNumber = wheelsNumber;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public int getWheelsNumber() {
        return wheelsNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "CarDto{" +
            "wheelsNumber=" + wheelsNumber +
            ", manufacturer='" + manufacturer + '\'' +
            ", model='" + model + '\'' +
            '}';
    }
}

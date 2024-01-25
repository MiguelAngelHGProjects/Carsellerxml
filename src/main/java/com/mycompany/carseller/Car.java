package com.mycompany.carseller;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Car")

@XmlType(propOrder = { "name", "brand" })
public class Car {

    private String name;
    private String brand;

    @XmlElement(name = "title")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getbrand() {
        return brand;
    }

    public void setbrand(String brand) {
        this.brand = brand;
    }
}
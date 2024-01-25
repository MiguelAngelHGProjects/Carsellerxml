package com.mycompany.carseller;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "com.vogella.xml.jaxb.gradle.model")
public class Carstore {

    private List<Car> carlist;
    private String name;
    private String location;

    @XmlElementWrapper(name = "carlist")
    @XmlElement(name = "Car")
    public List<Car> getcarlist() {
        return carlist;
    }

    public void setcarlist(List<Car> carlist) {
        this.carlist = carlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

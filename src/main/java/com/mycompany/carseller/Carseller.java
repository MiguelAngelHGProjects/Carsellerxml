package com.mycompany.carseller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Carseller {

    private static final String CARSTORE_XML = "./carstore-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        var carlist = new ArrayList<Car>();

        var car1 = new Car();
        car1.setName("m3");
        car1.setbrand("BMW");
        carlist.add(car1);

        var car2 = new Car();
         car2.setName("AMG c63");
        car2.setbrand("Mercedes-benz");
        carlist.add(car2);

        var Carstore = new Carstore();
        Carstore.setName("Fraport Bookstore");
        Carstore.setLocation("Frankfurt Airport");
        Carstore.setcarlist(carlist);

        JAXBContext context = JAXBContext.newInstance(Carstore.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        m.marshal(Carstore, System.out);

        m.marshal(Carstore, new File(CARSTORE_XML));

        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        Carstore carstore2 = (Carstore) um.unmarshal(new FileReader(
                CARSTORE_XML));
        List<Car> list = carstore2.getcarlist();
        for (Car Car : list) {
            System.out.println("Car: " + Car.getName() + " from "
                    + Car.getbrand());
        }
    }
}
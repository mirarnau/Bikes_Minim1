package edu.upc.dsa.util;

import edu.upc.dsa.models.Bike;
import edu.upc.dsa.models.Station;
import edu.upc.dsa.models.User;

import java.sql.SQLOutput;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {

        MyBike manager = MyBikeImpl.getInstance();

        //USERS
        User user1 = new User("Arnau");
        User user2 = new User("Bianca");
        User user3 = new User("Montse");
        User user4 = new User("Joan");

        //BIKES
        Bike bike0 = new Bike(0, 20);
        Bike bike1 = new Bike(1, 5.4);
        Bike bike2 = new Bike(2, 36.7);
        Bike bike3 = new Bike (3, 2);
        Bike bike4 = new Bike (4, 0);
        Bike bike5 = new Bike (5, 90);


        //STATIONS
        Station station0 = new Station(0);
        Station station1 = new Station(1);
        Station station2 = new Station(2);

        Station[] arrayAvailableStations = new Station[] {station0, station1, station2};
        manager.setArrayStations(arrayAvailableStations);

        manager.addUser(user1);
        manager.addUser(user2);
        manager.addUser(user3);
        manager.addUser(user4);

        manager.addBike(bike0);
        manager.addBike(bike1);
        manager.addBike(bike2);
        manager.addBike(bike3);
        manager.addBike(bike4);

        manager.addStation(station0);
        manager.addStation(station1);
        manager.addStation(station2);

        //And now we can add bikes to every station.
        station0.addBikeToStation(bike0);
        station0.addBikeToStation(bike1);
        station0.addBikeToStation(bike2);
        station1.addBikeToStation(bike3);
        station1.addBikeToStation(bike4);
        station2.addBikeToStation(bike5);

        //Now the users will pick bikes.
        user1.takeBike(bike0);
        user1.takeBike(bike1);
        user1.takeBike(bike5);
        user2.takeBike(bike2);
        user3.takeBike(bike3);
        user3.takeBike(bike4);

        /** Let's see the results */

        for (Bike b : user1.getListBikesUser()){
            System.out.println("LIST OF BIKES OF THE USER 1");
            System.out.println("ID Byke: " + b.getIdBike());
        }

        System.out.println("---------------");
        System.out.println("Should be Arnau: " + manager.getUserByID("Arnau").getIdUser());
        System.out.println("The user has " + manager.getUserByID("Arnau").getListBikesUser().size() + " bikes.");
        System.out.println("---------------");

        System.out.println("Arnau has: " + manager.bikesByUser(user1.getIdUser()).size() + " bikes.");
        System.out.println("---------------");

        manager.bikesByStationOrderByKms(station0);
        System.out.println("---LIST OF ORDERED BIKES OF STATION 0---");
        for (Bike bike : station0.getListBikes()){
            System.out.println("Bike ID: " + bike.getIdBike());
        }

        System.out.println("---------------------");
        System.out.println("Number of bikes of the selected station: " + manager.getStationById(0).getListBikes().size());
















    }
}

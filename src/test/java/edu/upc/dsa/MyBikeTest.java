package edu.upc.dsa;

import edu.upc.dsa.models.Bike;
import edu.upc.dsa.models.Station;
import edu.upc.dsa.models.User;
import edu.upc.dsa.util.MyBike;
import edu.upc.dsa.util.MyBikeImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyBikeTest {
    MyBike manager = MyBikeImpl.getInstance();
    @After
    public void tearDown() {
        manager.cleanCache();
    }


    @Before
    public void setUp() {

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

        //Station[] arrayAvailableStations = new Station[] {station0, station1, station2};
        manager.setMaxNumStations(5);
        Station[] arrayAvailableStations = new Station[manager.getNumMaxStations()];
        manager.setArrayStations(arrayAvailableStations);



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
    }

    @Test
    public void testAddUser(){

    }
}

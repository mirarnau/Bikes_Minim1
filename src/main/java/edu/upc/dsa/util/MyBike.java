package edu.upc.dsa.util;
import edu.upc.dsa.models.Station;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Bike;

import java.util.HashMap;
import java.util.List;

public interface MyBike {
    HashMap getAllUsers ();
    void addUser (User user);
    void addStation (Station station);
    void addBike (Bike bike);
    void bikesByStationOrderByKms (Station station);
    Bike getBike (Bike bike);
    List<Bike> bikesByUser (User user);
    Station[] getArrayStations ();
    void setArrayStations (Station[] arrayStations);

    User getUserByID (String idUser);

}

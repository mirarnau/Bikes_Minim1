package edu.upc.dsa.util;
import edu.upc.dsa.models.Station;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Bike;


public interface MyBike {
    void addUser (User user);
    void getInfoUser(User user);
    void addStation (Station station);
    void bikesByStationOrderByKms (Station station);
}

package edu.upc.dsa.util;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Bike;
import edu.upc.dsa.models.Station;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MyBikeImpl implements MyBike{
    private static MyBikeImpl instance;
    Station [] arrayStations;
    List<Bike> listAllBikes;  /** List of all bikes in the system */
    int numStations; /** Parameter that determines the length of the list of all bikes array */
    HashMap <String, User> usersHashMap;

    /**Singleton */
    private MyBikeImpl() {
    }
    public static MyBike getInstance(){
        if (instance==null) {
            instance = new MyBikeImpl();
        }
        return instance;
    }

    public void addUser (User user){
        this.usersHashMap.put(user.getIdUser(), user);
    }

    public void addStation(Station station){
        this.arrayStations[numStations] = station;
    }

    public void addBike (Bike bike){
        this.listAllBikes.add(bike);
    }

    /** Orders the bikes in a given station by its kilometers.*/
    public void bikesByStationOrderByKms (Station station){
        Collections.sort(station.getListBikes());
    }

    public void getInfoUser(User user) {
        this.usersHashMap.get(user.getIdUser());
    }

    public Bike getBike (Bike bike){
        Bike bk = null;
        for (Bike b : this.listAllBikes){
            if (b.getIdBike() == bike.getIdBike()){
                bk = b;
            }
        }
        return bk;
    }

    /** Returns the list of bikes of a user. */
    public List<Bike> bikesByUser (User u){
        return u.getListBikesUser();
    }


}

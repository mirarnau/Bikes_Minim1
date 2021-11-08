package edu.upc.dsa.util;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Bike;
import edu.upc.dsa.models.Station;

import java.util.*;

public class MyBikeImpl implements MyBike{
    private static MyBikeImpl instance;
    Station [] arrayStations;
    List<Bike> listAllBikes = new LinkedList<Bike>();  /** List of all bikes in the system */
    int numStations; /** Parameter that determines the length of the list of all bikes array */
    HashMap <String, User> usersHashMap = new HashMap<String, User>();

    /**Singleton */
    private MyBikeImpl() {
    }
    public static MyBike getInstance(){
        if (instance==null) {
            instance = new MyBikeImpl();
        }
        return instance;
    }

    public HashMap<String, User> getAllUsers(){
        return this.usersHashMap;
    }

    public void addUser (User user){
        this.usersHashMap.put(user.getIdUser(), user);
    }

    public void addStation(Station station){
        this.arrayStations[this.numStations] = station;
        this.numStations++;
    }

    public void addBike (Bike bike){
        this.listAllBikes.add(bike);
    }

    /** Orders the bikes in a given station by its kilometers.*/
    public void bikesByStationOrderByKms (Station station){
        Collections.sort(station.getListBikes());
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
    public List<Bike> bikesByUser (User user){
        return user.getListBikesUser();
    }

    public Station[] getArrayStations (){
        return this.arrayStations;
    }

    public void setArrayStations (Station[] arrayStations){
        this.arrayStations = arrayStations;
        this.numStations = 0;
    }

    public User getUserByID (String idUser){
        return this.usersHashMap.get(idUser);
    }


}

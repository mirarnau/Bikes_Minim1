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
    int numMaxStations; /** Determines the lenth of the array arrayStations */
    HashMap <String, User> usersHashMap = new HashMap <String, User>();

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

    /** Gets bike from ID */
    public Bike getBike (int idBike){
        Bike bike = null;
        for (Bike b : this.listAllBikes){
            if (b.getIdBike() == idBike){
                bike = b;
            }
        }
        return bike;
    }

    /** Returns the list of bikes of a user. */
    public List<Bike> bikesByUser (String idUser){
        return this.getUserByID(idUser).getListBikesUser();
    }

    public Station[] getArrayStations (){
        return this.arrayStations;
    }

    public void setArrayStations (Station[] arrayStations){
        this.arrayStations = arrayStations;
        this.numMaxStations = arrayStations.length;
        this.numStations = 0;
    }

    public User getUserByID (String idUser){
        return this.usersHashMap.get(idUser);
    }

    public int getNumMaxStations (){
        return this.numMaxStations;
    }

    public Station getStationById (int idStation){
        Station station = null;
        for (Station s : this.arrayStations){
            if (s.getIdStation() == idStation){
                station = s;
            }
        }
        return station;
    }


}

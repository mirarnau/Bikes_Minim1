package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Station {
    private int idStation;
    private List<Bike> listBikes = new LinkedList<Bike>();

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }

    public int getIdStation() {
        return idStation;
    }

    public List<Bike> getListBikes() {
        return listBikes;
    }

    public void addBikeToStation(Bike bike){
        this.listBikes.add(bike);
    }

    public void dropBikeStation(Bike bike){
        this.listBikes.remove(bike);
    }

    public Station(int idStation) {
        this.idStation = idStation;
    }
    public Station(){};
}

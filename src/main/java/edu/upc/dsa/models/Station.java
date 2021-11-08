package edu.upc.dsa.models;

import java.util.List;

public class Station {
    private int idStation;
    private List<Bike> listBikes;

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }

    public int getIdStation() {
        return idStation;
    }

    public List<Bike> getListBikes() {
        return listBikes;
    }

    public void addBikeStation(Bike bike){
        this.listBikes.add(bike);
    }

    public void dropBikeStation(Bike bike){
        this.listBikes.remove(bike);
    }


    public Station(int idStation, List<Bike> listBikes) {
        this.idStation = idStation;
        this.listBikes = listBikes;
    }
    public Station(){};
}

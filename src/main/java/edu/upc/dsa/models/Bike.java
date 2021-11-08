package edu.upc.dsa.models;

public class Bike implements Comparable<Bike> {
    private int idBike;
    private int kilometers;

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public void setIdBike(int idBike) {
        this.idBike = idBike;
    }

    public int getIdBike() {
        return idBike;
    }

    public int getKilometers() {
        return kilometers;
    }

    public int compareTo (Bike b){
        return Integer.compare(this.kilometers, b.getKilometers());
    }

    /** Constructors */
    public Bike(int idBike) {
        this.idBike = idBike;
    }

    public Bike(){};
}

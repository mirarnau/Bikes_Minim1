package edu.upc.dsa.models;

public class Bike implements Comparable<Bike> {
    private int idBike;
    private double kilometers;

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public void setIdBike(int idBike) {
        this.idBike = idBike;
    }

    public int getIdBike() {
        return idBike;
    }

    public double getKilometers() {
        return kilometers;
    }

    public int compareTo (Bike b){
        return Double.compare(this.kilometers, b.getKilometers());
    }

    /** Constructors */
    public Bike(int idBike, double kilometers) {
        this.idBike = idBike;
        this.kilometers = kilometers;
    }

    public Bike(){};
}

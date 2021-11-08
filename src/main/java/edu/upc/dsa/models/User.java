package edu.upc.dsa.models;

import java.util.List;

public class User {
    private String idUser;
    private List<Bike> listBikesUser;

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdUser() {
        return idUser;
    }


    public User (String idUser){
        this.idUser = idUser;

    }

    public List<Bike> getListBikesUser() {
        return listBikesUser;
    }

    public User(){};

    public void takeBike (Bike bike){
        this.listBikesUser.add(bike);
    }

    public void dropBike (Bike bike){
        this.listBikesUser.remove(bike);
    }

}

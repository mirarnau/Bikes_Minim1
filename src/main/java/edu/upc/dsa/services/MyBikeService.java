package edu.upc.dsa.services;

import edu.upc.dsa.models.Bike;
import edu.upc.dsa.models.Station;
import edu.upc.dsa.models.User;

import edu.upc.dsa.util.MyBike;
import edu.upc.dsa.util.MyBikeImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/Bike", description = "Endpoint to Covid19 vaccination service.")
@Path("/Bike")
public class MyBikeService {
    private MyBike manager;

    public MyBikeService(){
        this.manager = MyBikeImpl.getInstance();
        if (true){
            //USERS
            User user1 = new User("Arnau");
            User user2 = new User("Bianca");
            User user3 = new User("Montse");
            User user4 = new User("Joan");

            //BIKES
            Bike bike0 = new Bike(0, 20);
            Bike bike1 = new Bike(1, 5.4);
            Bike bike2 = new Bike(2, 36.7);
            Bike bike3 = new Bike (3, 2);
            Bike bike4 = new Bike (4, 0);
            Bike bike5 = new Bike (5, 90);


            //STATIONS
            Station station0 = new Station(0);
            Station station1 = new Station(1);
            Station station2 = new Station(2);

            Station[] listAvailableStations = new Station[] {station0, station1, station2};
            manager.setArrayStations(listAvailableStations);

            manager.addUser(user1);
            manager.addUser(user2);
            manager.addUser(user3);
            manager.addUser(user4);

            manager.addBike(bike0);
            manager.addBike(bike1);
            manager.addBike(bike2);
            manager.addBike(bike3);
            manager.addBike(bike4);

            manager.addStation(station0);
            manager.addStation(station1);
            manager.addStation(station2);

            //And now we can add bikes to every station.
            station0.addBikeToStation(bike0);
            station0.addBikeToStation(bike1);
            station0.addBikeToStation(bike2);
            station1.addBikeToStation(bike3);
            station1.addBikeToStation(bike4);
            station2.addBikeToStation(bike5);

            //Now the users will pick bikes.
            user1.takeBike(bike0);
            user1.takeBike(bike1);
            user1.takeBike(bike5);
            user2.takeBike(bike2);
            user3.takeBike(bike3);
            user3.takeBike(bike4);
        }
    }

    //----------------------------------------------

    @POST
    @ApiOperation(value = "Add a user to the system.", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added user.")
    })
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser (User user) {
        this.manager.addUser(user);
        return Response.status(201).build();
    }

    //----------------------------------------------

    @POST
    @ApiOperation(value = "Add a station to the system", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added station."),
            @ApiResponse(code = 500, message = "ERROR, maximum number of stations reached.")

    })
    @Path("/addStation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStation (Station station) {
        if (this.manager.getArrayStations().length == this.manager.getNumMaxStations()){
            return Response.status(500).build();
        }
        else {
            this.manager.addStation(station);
            return Response.status(201).build();
        }
    }

    //----------------------------------------------

    @POST
    @ApiOperation(value = "Add a bike to the system", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added bike.")}
    )
    @Path("/addBike")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBike (Bike bike) {
        manager.addBike(bike);
       return Response.status(201).build();
    }

    //----------------------------------------------

    @GET
    @ApiOperation(value = "Get bikes from a station ordered by km.", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Bike.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "ERRROR")
    })

    @Path("/getBikesOrdered/{idStation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBikesByStationOrderByKms(@PathParam("idStation") int idStation){
        manager.bikesByStationOrderByKms(manager.getStationById(idStation));
        GenericEntity<List<Bike>> entity = new GenericEntity<List<Bike>>(manager.getStationById(idStation).getListBikes()){};
        return Response.status(201).entity(entity).build();
    }

    //----------------------------------------------

    @GET
    @ApiOperation(value = "Get a bike given its ID", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Bike.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "ERRROR, there's no nike with the specified ID.")
    })

    @Path("/getBike/{idBike}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBike(@PathParam("idBike") int idBike){
        if (this.manager.getBike(idBike) != null){
            Bike bike = this.manager.getBike(idBike);
            return Response.status(201).entity(bike).build();
        }
        else{
            return Response.status(404).build();
        }
    }

    //----------------------------------------------

    @GET
    @ApiOperation(value = "Get the list of bikes of a specified user", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Bike.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "ERRROR, that user has no bikes.")
    })

    @Path("/bikesByUser/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response bikesByUser(@PathParam("idUser") String idUser) {
        if (manager.bikesByUser(idUser).size() > 0){
            GenericEntity<List<Bike>> entity = new GenericEntity<List<Bike>>(manager.bikesByUser(idUser)){};
            return Response.status(201).entity(entity).build();
        }
        else{
            return Response.status(404).build();
        }
    }


}

package nl.hu.fnt.gsos.rest;

import nl.hu.fnt.gsos.service.ServiceProvider;
import nl.hu.fnt.gsos.service.Track;
import nl.hu.fnt.gsos.service.TrackServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tracks")
public class TrackService {
    ServiceProvider provider = new ServiceProvider() ;

    @GET
    @Path("/hello")
    public Response getMsg() {

        String output = "Jersey say : hello";

        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/tracks")
    public Response getTrackList() {
        TrackServiceImpl trackService = provider.getTrackService();

        String trackList = trackService.trackListString ;

        return Response.status(200).entity(trackList).build();
    }

    @GET
    @Path("/tracks/count")
    public Response getAmmountOfTracks() {
        TrackServiceImpl trackService = provider.getTrackService();

        String trackListCount = "" + trackService.trackListCount ;

        return Response.status(200).entity(trackListCount).build();
    }

    @GET
    @Path("/trackById/{id}")
    public Response getTrackById(@PathParam("id") int id) {
        TrackServiceImpl trackService = provider.getTrackService();

        String trackInformation = "" + trackService.getTrackById(id) ;
        return Response.status(200).entity(trackInformation).build();
    }

    @PUT
    @Path("/createtrack")
    @Consumes(MediaType.APPLICATION_XML)
    public Response createNewTrackById(Track track) {
        TrackServiceImpl trackService = provider.getTrackService();

        String trackAdded = "" + trackService.addNewTrack(track) ;
        return Response.status(200).entity(trackAdded).build();
    }

    @DELETE
    @Path("/tracks/delete/{id}")
    public Response deleteTrackById(@PathParam("id") int id) {
        TrackServiceImpl trackService = provider.getTrackService();

        String isTrackDeleted = "" + trackService.remove(id) ;
        return Response.status(200).entity(isTrackDeleted).build();

    }

}
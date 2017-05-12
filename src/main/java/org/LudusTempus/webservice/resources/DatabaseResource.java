package org.LudusTempus.webservice.resources;

import brugerautorisation.transport.soap.Brugeradmin;
import database.SQLFunctions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

@Path("/database")
public class DatabaseResource {

    @GET
    @Path("/createUser={studieNr}+{userName}+{skypeAccount}+{discordAccount}+{summonerName}+{lolMainRole}+{lolOffRole}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(@PathParam("studieNr") String studieNr, @PathParam("userName") String userName, @PathParam("skypeAccount") String skypeAccount, @PathParam("discordAccount") String discordAccount, @PathParam("summonerName") String summonerName, @PathParam("lolMainRole") int lolMainRole, @PathParam("lolOffRole") int lolOffRole)  {

        SQLFunctions sql = new SQLFunctions();

        sql.createUser(studieNr, userName, skypeAccount, discordAccount, summonerName, lolMainRole, lolOffRole);

        return Response.ok("User created with success").header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/getUser={studieNr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("studieNr") String studieNr)  {

        SQLFunctions sql = new SQLFunctions();

        return Response.ok(sql.getUserName(studieNr)).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/getSkype={studieNr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSkype(@PathParam("studieNr") String studieNr)  {

        SQLFunctions sql = new SQLFunctions();

        return Response.ok(sql.getSkypeAccount(studieNr)).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/getDiscord={studieNr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscord(@PathParam("studieNr") String studieNr)  {

        SQLFunctions sql = new SQLFunctions();

        return Response.ok(sql.getDiscordAccount(studieNr)).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/getSummoner={studieNr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSummoner(@PathParam("studieNr") String studieNr)  {

        SQLFunctions sql = new SQLFunctions();

        return Response.ok(sql.getSummonerName(studieNr)).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/getMain={studieNr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMain(@PathParam("studieNr") String studieNr)  {

        SQLFunctions sql = new SQLFunctions();

        return Response.ok(Integer.toString(sql.getLolMainRole(studieNr))).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/getOff={studieNr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOff(@PathParam("studieNr") String studieNr)  {

        SQLFunctions sql = new SQLFunctions();

        return Response.ok(Integer.toString(sql.getLolOffRole(studieNr))).header("Access-Control-Allow-Origin", "*").build();
    }

}

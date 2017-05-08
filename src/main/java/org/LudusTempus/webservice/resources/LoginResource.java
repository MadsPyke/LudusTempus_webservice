package org.LudusTempus.webservice.resources;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import brugerautorisation.transport.soap.Brugeradmin;
import database.SQLFunctions;
import org.eclipse.persistence.internal.oxm.Constants;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.ws.rs.core.Response;

import static database.SQLFunctions.*;

@Path("/brugerautorisation")
public class LoginResource {

    @GET
    @Path("/hentBruger={studieNr}+{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("studieNr") String studieNr, @PathParam("password") String password) throws MalformedURLException {

        brugerautorisation.data.Bruger b = null;

        URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
        QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
        Service service = Service.create(url, qname);

        Brugeradmin ba = service.getPort(Brugeradmin.class);

        try {
            b = ba.hentBruger(studieNr, password);
        } catch(Exception e) {
            return null;
        }

        return Response.ok(b).header("Access-Control-Allow-Origin", "*").build();
    }


    @GET
    @Path("/checkBruger={studieNr}")
    @Produces(MediaType.TEXT_PLAIN)
    public String checkUser(@PathParam("studieNr") String studieNr)  {

        SQLFunctions sql = new SQLFunctions();
        System.out.println(sql.getUserName(studieNr));
        return sql.getUserName(studieNr);
    }


    @GET
	@Path("/changePW={studieNr}+{oldPassword}+{newPassword0}+{newPassword1}")
	@Produces(MediaType.APPLICATION_JSON)
	public void changePW(@PathParam("studieNr") String studieNr, @PathParam("oldPassword") String oldPassword, @PathParam("newPassword0") String newPassword0, @PathParam("newPassword1") String newPassword1) throws MalformedURLException {
		
        brugerautorisation.data.Bruger b;

        URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
        QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
        Service service = Service.create(url, qname);

        Brugeradmin ba = service.getPort(Brugeradmin.class);

        b = ba.hentBruger(studieNr, oldPassword);

        if (newPassword0.equals(newPassword1)) {
            ba.ændrAdgangskode(studieNr, oldPassword, newPassword0);
        }
		
	}

    @OPTIONS
    @Path("/getsample")
    public javax.ws.rs.core.Response getOptions() {
        return javax.ws.rs.core.Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }



	
}

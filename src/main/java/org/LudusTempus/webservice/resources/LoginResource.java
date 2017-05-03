package org.LudusTempus.webservice.resources;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.sun.research.ws.wadl.Response;
import brugerautorisation.transport.soap.Brugeradmin;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

@Path("/brugerautorisation")
public class LoginResource {
	
	@GET
	@Path("/hentBruger={studieNr}+{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public brugerautorisation.data.Bruger getUser(@PathParam("studieNr") String studieNr, @PathParam("password") String password) throws MalformedURLException {
		
		brugerautorisation.data.Bruger b = null;
		
		URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
        QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
        Service service = Service.create(url, qname);
		
        Brugeradmin ba = service.getPort(Brugeradmin.class);
        
        try {
        b = ba.hentBruger(studieNr, password);
        } catch(Exception e) {
        	return b;
        }
		return b;
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
	
	

	
}
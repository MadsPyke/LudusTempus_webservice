package org.LudusTempus.webservice.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/league")
public class LeagueOfLegendsResource {
	
    final String key = "RGAPI-B3D7B0F4-E07D-426E-877D-6235F952B9F0";
	

	@GET
	@Path("/getGames={summonerName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLeagueOfLegendsGamesInfo(@PathParam("summonerName") String summonerName) {

		long summonerID = getSummonerID(summonerName);

        String url = "https://euw.api.riotgames.com/api/lol/EUW/v1.3/game/by-summoner/" + summonerID + "/recent?api_key="+key;

        String s = new String();

        Client cLient = ClientBuilder.newClient();
        Response response = cLient.target(url).request(MediaType.APPLICATION_JSON).get();
        
        return response;
	}
	
	@GET
	@Path("/getBasic={summonerName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLeagueOfLegendsBasicInfo(@PathParam("summonerName") String summonerName) {

        String url1 = "https://euw.api.riotgames.com/api/lol/EUW/v1.4/summoner/by-name/"+summonerName+"?api_key="+key;
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(url1).request(MediaType.APPLICATION_JSON).get();
        return response;
	}
	
	@GET
	@Path("/getRanked={summonerName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLeagueOfLegendsRankedInfo(@PathParam("summonerName") String summonerName) {
		
		long summonerID = getSummonerID(summonerName);

		String url = "https://euw.api.riotgames.com/api/lol/EUW/v1.3/stats/by-summoner/"+ summonerID +"/ranked?season=SEASON2017&api_key="+key;
		Client client = ClientBuilder.newClient();
		Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();
        
        return response;
	}
	
	@GET
	@Path("/getLeagues={summonerName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLeagueOfLegendsLeaguesInfo(@PathParam("summonerName") String summonerName) {
		
		long summonerID = getSummonerID(summonerName);

		String url = "https://euw.api.riotgames.com/api/lol/EUW/v1.3/stats/by-summoner/"+ summonerID +"/summary?season=SEASON2017&api_key="+key;
        Client client = ClientBuilder.newClient();
        Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();
        
        return response;
	}
	
	
	private long getSummonerID(String username) {

	        String url = "https://euw.api.riotgames.com/api/lol/EUW/v1.4/summoner/by-name/"+username+"?api_key=" + key;

	        String s = new String();
	        long l = -1;


	        Client client = ClientBuilder.newClient();
	        Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();

	        s = response.readEntity(String.class);

	        try {
	            JSONObject jsonObject = new JSONObject(s);
	            JSONObject tmp = jsonObject.getJSONObject(username.toLowerCase());
	            l = tmp.getLong("id");
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }

	        return l;
	}
}

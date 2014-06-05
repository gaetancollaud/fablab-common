package net.collaud.fablab.webservice.client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import net.collaud.fablab.webservice.WebServicePath;
import net.collaud.fablab.webservice.response.PingResponse;

public class PingClient {
	private final WebTarget webTarget;
	private final Client client;

	public PingClient(String url) {
		client = ClientBuilder.newClient();
		webTarget = client.target(url).path(WebServicePath.BASE_URL).path(WebServicePath.PING_URL);
	}

	public PingResponse ping(String content) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.queryParam(WebServicePath.PARAM_CONTENT, content);
		return resource.request(MediaType.APPLICATION_JSON).get(PingResponse.class);
	}

	public void close() {
		client.close();
	}
	
	public static void main(String[] args) {
		PingClient dc = new PingClient("localhost:8083");
		PingResponse pingResponse = dc.ping("badsfas");
		System.out.println("ping received : " +pingResponse.getContent());
		if(pingResponse.isError()){
			System.out.println("error "+pingResponse.getErrors().get(0));
		}
	}
	
}

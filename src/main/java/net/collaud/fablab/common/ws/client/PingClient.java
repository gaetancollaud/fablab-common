package net.collaud.fablab.common.ws.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import net.collaud.fablab.common.ws.WebServicePath;
import net.collaud.fablab.common.ws.exception.WebServiceException;
import net.collaud.fablab.common.ws.response.PingResponse;

public class PingClient  extends AbstractClient{

	private final WebTarget webTarget;
	private final Client client;

	public PingClient(String url) {
		client = ClientBuilder.newClient();
		webTarget = client.target(url).path(WebServicePath.BASE_URL).path(WebServicePath.PING_URL);
	}

	public PingResponse ping(String content) throws WebServiceException {
		WebTarget resource = webTarget;
		resource = resource.queryParam(WebServicePath.PARAM_CONTENT, content);
		return requestJson(resource, PingResponse.class);
	}

	public void close() {
		client.close();
	}
}

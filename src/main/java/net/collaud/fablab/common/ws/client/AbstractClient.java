package net.collaud.fablab.common.ws.client;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import net.collaud.fablab.common.ws.exception.WebServiceException;

/**
 *
 * @author gaetan
 */
abstract public class AbstractClient {
	
	protected <T> T requestJson(WebTarget resource, Class<T> clazz) throws WebServiceException{
		return request(MediaType.APPLICATION_JSON, resource, clazz);
	}
	protected <T> T requestXml(WebTarget resource, Class<T> clazz) throws WebServiceException{
		return request(MediaType.APPLICATION_XML, resource, clazz);
	}
	
	private <T> T request(String mediaType, WebTarget resource, Class<T> clazz) throws WebServiceException{
		try {
			return resource.request(mediaType).get(clazz);
		} catch (ProcessingException | WebApplicationException ex) {
			throw new WebServiceException("Error when requesting "+resource.getUri(), ex);
		}
	}
}

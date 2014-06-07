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
	
	public static final String MEDIA_TYPE = MediaType.APPLICATION_JSON;
	
	
	protected <T> T request(WebTarget resource, Class<T> clazz) throws WebServiceException{
		try {
			return resource.request(MEDIA_TYPE).get(clazz);
		} catch (ProcessingException | WebApplicationException ex) {
			throw new WebServiceException("Error when requesting "+resource.getUri(), ex);
		}
	}
}

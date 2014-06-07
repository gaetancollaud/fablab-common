package net.collaud.fablab.common.ws.exception;

/**
 *
 * @author gaetan
 */
public class WebServiceException extends Exception {

	public WebServiceException() {
	}

	public WebServiceException(String message) {
		super(message);
	}

	public WebServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}

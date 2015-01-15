package net.collaud.fablab.common.ws.exception;

/**
 *
 * @author Gaetan Collaud <gaetancollaud@gmail.com>
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

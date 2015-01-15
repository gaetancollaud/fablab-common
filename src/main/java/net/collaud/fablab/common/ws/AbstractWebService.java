package net.collaud.fablab.common.ws;

/**
 *
 * @author Gaetan Collaud <gaetancollaud@gmail.com>
 */
abstract public class AbstractWebService {
	
	public static final String DEFAULT_TOKEN = "higuys!";
	
	protected void checkToken(String token){
		if(token==null || !token.equals(getToken())){
			throw new RuntimeException("Wrong token : "+token);
		}
	}
	
	abstract protected String getToken();
	
}

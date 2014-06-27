package net.collaud.fablab.common.ws;

/**
 *
 * @author gaetan
 */
abstract public class AbstractWebService {
	
	public static final String DEFAULT_TOKEN = "higuys!";
	
	protected void checkToken(String token){
		//FIXME Get "token" from config file
		if(token==null || !token.equals(getToken())){
			throw new RuntimeException("Wrong token : "+token);
		}
	}
	
	abstract protected String getToken();
	
}

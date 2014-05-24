package net.collaud.fablab.webservice;

/**
 *
 * @author gaetan
 */
abstract public class AbstractWebService {
	
	protected void checkToken(String token){
		//FIXME Get "token" from config file
		if(token==null || !token.equals("salut")){
			throw new RuntimeException("Wrong token : "+token);
		}
	}
	
}

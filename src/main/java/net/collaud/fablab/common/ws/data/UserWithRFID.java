package net.collaud.fablab.common.ws.data;

/**
 *
 * @author Gaetan Collaud <gaetancollaud@gmail.com>
 */
public class UserWithRFID {

	private String login;
	private String rfid;

	public UserWithRFID(String login, String rfid) {
		this.login = login;
		this.rfid = rfid;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
}

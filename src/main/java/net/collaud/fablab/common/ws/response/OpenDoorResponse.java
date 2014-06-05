package net.collaud.fablab.common.ws.response;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author gaetan
 */
@XmlRootElement
public class OpenDoorResponse extends AbstractResponse implements Serializable{

	private boolean granted;

	public OpenDoorResponse() {
		super();
	}

	public OpenDoorResponse(boolean granted) {
		this.granted = granted;
	}

	public boolean isGranted() {
		return granted;
	}

	public void setGranted(boolean granted) {
		this.granted = granted;
	}

}

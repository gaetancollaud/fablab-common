package net.collaud.fablab.common.ws.response;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gaetan
 */
@XmlRootElement
public class DoorStatusResponse extends AbstractResponse implements Serializable{

	private boolean doorOpen;
	private boolean alarmOn;

	public DoorStatusResponse(boolean doorOpen, boolean alarmOn) {
		this.doorOpen = doorOpen;
		this.alarmOn = alarmOn;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}

	public void setDoorOpen(boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}

	public void setAlarmOn(boolean alarmOn) {
		this.alarmOn = alarmOn;
	}
}

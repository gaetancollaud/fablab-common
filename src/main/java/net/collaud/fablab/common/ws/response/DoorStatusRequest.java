package net.collaud.fablab.common.ws.response;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gaetan
 */
@XmlRootElement
public class DoorStatusRequest extends AbstractResponse implements Serializable {

	private boolean doorOpen;
	private boolean alarmOn;
	private String lastRfid;

	public DoorStatusRequest() {
	}

	public DoorStatusRequest(boolean doorOpen, boolean alarmOn) {
		this.doorOpen = doorOpen;
		this.alarmOn = alarmOn;
	}

	public DoorStatusRequest(boolean doorOpen, boolean alarmOn, String lastRfid) {
		this.doorOpen = doorOpen;
		this.alarmOn = alarmOn;
		this.lastRfid = lastRfid;
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

	public String getLastRfid() {
		return lastRfid;
	}

	public void setLastRfid(String lastRfid) {
		this.lastRfid = lastRfid;
	}
}

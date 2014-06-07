package net.collaud.fablab.common.ws.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gaetan
 */
@XmlRootElement
public class PingResponse extends AbstractResponse {

	private String content;

	public PingResponse() {
	}

	public PingResponse(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}

package net.collaud.fablab.common.ws.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gaetan
 */
@XmlRootElement
public class PingResponse extends AbstractResponse {

	private final String content;

	public PingResponse(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}

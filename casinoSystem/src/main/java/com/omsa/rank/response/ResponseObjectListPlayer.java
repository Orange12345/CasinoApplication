package com.omsa.rank.response;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omsa.rank.request.PlayerRequest;

public class ResponseObjectListPlayer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("message")
	private String message = null;
	@JsonProperty("statusCode")
	private String statusCode = null;
	@JsonProperty("responsePayload")
	private PlayerRequest responsePayload = null;

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public PlayerRequest getResponsePayload() {
		return responsePayload;
	}

	public void setResponsePayload(PlayerRequest responsePayload) {
		this.responsePayload = responsePayload;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o != null && this.getClass() == o.getClass()) {
			ResponseObjectListPlayer responseObjectListPlayer = (ResponseObjectListPlayer) o;
			return Objects.equals(this.message, responseObjectListPlayer.message)
					&& Objects.equals(this.statusCode, responseObjectListPlayer.statusCode)
					&& Objects.equals(this.responsePayload, responseObjectListPlayer.responsePayload);
		} else {
			return false;
		}
	}

	public int hashCode() {
		return Objects.hash(new Object[]{this.message, this.statusCode,this.responsePayload});
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResponseObjectListOccupation {\n");
		sb.append("    message: ").append(this.toIndentedString(this.message)).append("\n");
		sb.append("    statusCode: ").append(this.toIndentedString(this.statusCode)).append("\n");
		sb.append("    responsePayload: ").append(this.toIndentedString(this.responsePayload)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(Object o) {
		return o == null ? "null" : o.toString().replace("\n", "\n    ");
	}

}

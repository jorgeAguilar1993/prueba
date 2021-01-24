package es.prueba.issue.vo;

public class RequestLock {

	private String lock_reason;

	public RequestLock() {
		this.lock_reason = "";
	}

	public String getLock_reason() {
		return lock_reason;
	}

	public void setLock_reason(String lock_reason) {
		this.lock_reason = lock_reason;
	}

}

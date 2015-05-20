package database;

public class Notification {
	private String username;
	private String message;
	private int id;

	public Notification() {
		super();
	}

	public Notification(String username, String message, int id) {
		super();
		this.username = username;
		this.message = message;
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Notification [username=" + username + ", message=" + message
				+ ", id=" + id + "]";
	}

}

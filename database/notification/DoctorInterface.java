package database.notification;


public interface DoctorInterface {

	public void notifyDoctor(String username, String message);

	public String getUsername();
}

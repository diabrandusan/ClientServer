package database.notification;

public interface SecretaryInterface {

	public abstract void registerDoctor(DoctorInterface doctor);

	public abstract void unregisterDoctor(DoctorInterface doctor);

	public void notifyDoctor(String doctorUsername, String message);

}

package database.notification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.Notification;

public class Doctor implements DoctorInterface {
	private final String username;

	public Doctor(String username) {
		this.username = username;
	}

	public Notification[] getNotifications() {
		String query = "select * from notify where username=?";
		List<Notification> notifications = new ArrayList<Notification>();
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				notifications.add(new Notification(
						result.getString("username"), result
								.getString("message"), result.getInt("id")));
			}
		} catch (SQLException e) {
			System.err.println("Error inserting into table notify: ");
			e.printStackTrace();
		}
		return notifications.toArray(new Notification[notifications.size()]);
	}

	public void addNotify(String username, String message) {
		String query = "insert into notify(username, message) values (?,?)";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, username);
			statement.setString(2, message);
			statement.execute();
		} catch (SQLException e) {
			System.err.println("Error inserting into table notify: ");
			e.printStackTrace();
		}

	}

	public void deleteNotify(int idNotification) {
		String query = "delete from notify where id=?";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setInt(1, idNotification);
			statement.execute();
		} catch (SQLException e) {
			System.err.println("Error deleting from notify user: ");
			e.printStackTrace();
		}

	}

	@Override
	public void notifyDoctor(String username, String message) {
		addNotify(username, message);
	}

	@Override
	public String getUsername() {
		return username;
	}

}

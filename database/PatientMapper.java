package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientMapper extends MapperBase<Patient> {

	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		try (Connection con = DatabaseConnection.getConnection();
				Statement statement = con.createStatement()) {
			ResultSet resultSet = statement
					.executeQuery("select * from patient");
			while (resultSet.next()) {
				Patient patient = map(resultSet);
				patients.add(patient);
			}

		} catch (SQLException e) {
			System.out.println("Error retrieving patients from mapper:"
					+ e.getStackTrace());
		}
		return patients;

	}

	public Patient getPatient(String cnp) {
		Patient patient = null;
		String query = "select * from patient where cnp=?";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, cnp);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				patient = map(resultSet);
			}
		} catch (SQLException e) {
			System.err.println("Error retrieving patient from mapper:"
					+ e.getStackTrace());
		}
		return patient;
	}

	public void addPatient(Patient patient) {

		String query = "insert into patient(cnp, namePatient, cardnumber, datebirth, address) values (?,?,?,?,?)";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, patient.getCnp());
			statement.setString(2, patient.getNamePatient());
			statement.setInt(3, patient.getCardnumber());
			statement.setDate(4, new java.sql.Date(patient.getDatebirth()
					.getTime()));
			statement.setString(5, patient.getAddress());
			statement.execute();
		} catch (SQLException e) {
			System.err.println("Error inserting into table patient: ");
			e.printStackTrace();
		}

	}

	public void updatePatient(Patient patient) {

		String query = "update patient set namePatient=?, cardnumber=?, datebirth=?, address=? where cnp=? ";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, patient.getNamePatient());
			statement.setInt(2, patient.getCardnumber());
			statement.setDate(3, new java.sql.Date(patient.getDatebirth()
					.getTime()));
			statement.setString(4, patient.getAddress());
			statement.setString(5, patient.getCnp());
			statement.execute();
		} catch (SQLException e) {
			System.err.println("Error inserting into table patient: ");
			e.printStackTrace();
		}

	}

	public void deletePatient(String cnp) {
		String query = "delete from patient where cnp=?";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, cnp);
			statement.execute();
		} catch (SQLException e) {
			System.err.println("Error deleting from table patient: ");
			e.printStackTrace();
		}

	}

	@Override
	protected Patient map(ResultSet resultSet) {
		Patient patient = null;
		try {
			patient = new Patient(resultSet.getString("cnp"),
					resultSet.getString("namePatient"),
					resultSet.getInt("cardnumber"),
					resultSet.getDate("datebirth"),
					resultSet.getString("address"));
		} catch (SQLException e) {
			System.err.println("Error retrieving consultation from mapper:"
					+ e.getStackTrace());
		}
		return patient;
	}

}

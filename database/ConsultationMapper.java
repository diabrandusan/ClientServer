package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultationMapper extends MapperBase<Consultation> {

	public List<Consultation> getAllConsultation() {
		List<Consultation> consultations = new ArrayList<Consultation>();
		try (Connection con = DatabaseConnection.getConnection();
				Statement statement = con.createStatement()) {
			ResultSet resultSet = statement
					.executeQuery("select * from consultation");
			while (resultSet.next()) {
				Consultation consultation = map(resultSet);
				consultations.add(consultation);
			}

		} catch (SQLException e) {
			System.out.println("Error retrieving consultations from mapper:"
					+ e.getStackTrace());
		}
		return consultations;

	}

	public List<Consultation> getConsultationId(int id) {
		List<Consultation> consultations = new ArrayList<Consultation>();
		String query = "select * from consultation where idConsultation=?";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Consultation consultation = map(resultSet);
				consultations.add(consultation);
			}

		} catch (SQLException e) {
			System.out.println("Error retrieving consultations from mapper:"
					+ e.getStackTrace());
		}
		return consultations;
	}

	public List<Consultation> getConsultationCnp(String cnp) {
		List<Consultation> consultations = new ArrayList<Consultation>();
		String query = "select * from consultation where cnp=?";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, cnp);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Consultation consultation = map(resultSet);
				consultations.add(consultation);
			}

		} catch (SQLException e) {
			System.out.println("Error retrieving consultation from mapper:"
					+ e.getStackTrace());
		}

		return consultations;
	}

	public Consultation getAccount(int id) {
		Consultation consultation = null;
		String query = "select * from consultation where idConsultation=?";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				consultation = map(resultSet);
			}
		} catch (SQLException e) {
			System.err.println("Error retrieving consultation from mapper:"
					+ e.getStackTrace());
		}
		return consultation;
	}

	public void addConsultation(Consultation consultation) {

		String query = "insert into consultation(idConsultation, cnp, username, date, description) values (?,?,?,?,?)";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setInt(1, consultation.getIdConsultation());
			statement.setString(2, consultation.getCnp());
			statement.setString(3, consultation.getNameDoctor());
			statement.setDate(4, new java.sql.Date(consultation.getDate()
					.getTime()));
			statement.setString(5, consultation.getDescription());
			statement.execute();
		} catch (SQLException e) {
			System.err.println("Error inserting into table consultations: ");
			e.printStackTrace();
		}

	}

	public void updateConsultation(Consultation consultation) {

		String query = "update consultation set cnp=?, username=?, date=?, description=? where idConsultation=? ";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, consultation.getCnp());
			statement.setString(2, consultation.getNameDoctor());
			statement.setDate(3, new java.sql.Date(consultation.getDate()
					.getTime()));
			statement.setString(4, consultation.getDescription());
			statement.setInt(5, consultation.getIdConsultation());
			statement.execute();
		} catch (SQLException e) {
			System.err.println("Error inserting into table consultation: ");
			e.printStackTrace();
		}

	}

	public void deleteConsultation(int id) {
		String query = "delete from consultation where idConsultation=?";
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(query)) {
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			System.err.println("Error deleting from table consultation: ");
			e.printStackTrace();
		}

	}

	@Override
	protected Consultation map(ResultSet resultSet) {
		Consultation consultation = null;
		try {
			consultation = new Consultation(resultSet.getInt("idConsultation"),
					resultSet.getString("cnp"),
					resultSet.getString("username"), resultSet.getDate("date"),
					resultSet.getString("description"));
		} catch (SQLException e) {
			System.err.println("Error retrieving consultation from mapper:"
					+ e.getStackTrace());
		}
		return consultation;
	}

}

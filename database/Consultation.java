package database;

import java.util.Date;

public class Consultation {

	private int idConsultation;
	private String cnp;
	private String nameDoctor;
	private Date date;
	private String description;

	public Consultation() {
		super();

	}

	public Consultation(int idConsultation, String cnp, String nameDoctor,
			Date date, String description) {
		super();
		this.idConsultation = idConsultation;
		this.cnp = cnp;
		this.nameDoctor = nameDoctor;
		this.date = date;
		this.description = description;
	}

	public int getIdConsultation() {
		return idConsultation;
	}

	public void setIdConsultation(int idConsultation) {
		this.idConsultation = idConsultation;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getNameDoctor() {
		return nameDoctor;
	}

	public void setNameDoctor(String nameDoctor) {
		this.nameDoctor = nameDoctor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Consultation [idConsultation=" + idConsultation + ", cnp="
				+ cnp + ", nameDoctor=" + nameDoctor + ", date=" + date
				+ ", description=" + description + "]";
	}

}

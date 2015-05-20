package database;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient {

	private String cnp;
	private String namePatient;
	private int cardnumber;
	private Date datebirth;
	private String address;

	public Patient() {
		super();

	}

	public Patient(String cnp, String namePatient, int cardnumber,
			Date datebirth, String address) {
		super();
		this.cnp = cnp;
		this.namePatient = namePatient;
		this.cardnumber = cardnumber;
		this.datebirth = datebirth;
		this.address = address;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getNamePatient() {
		return namePatient;
	}

	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}

	public int getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}

	public Date getDatebirth() {
		return datebirth;
	}

	public void setDatebirth(Date datebirth) {
		this.datebirth = datebirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [cnp=" + cnp + ", namePatient=" + namePatient
				+ ", cardnumber=" + cardnumber + ", datebirth=" + datebirth
				+ ", address=" + address + "]";
	}

}

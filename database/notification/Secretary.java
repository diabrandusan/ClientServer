package database.notification;

import java.util.ArrayList;
import java.util.List;

import database.Consultation;
import database.ConsultationMapper;
import database.Patient;
import database.PatientMapper;
import database.User;
import database.UserMapper;

public class Secretary implements SecretaryInterface {

	public List<DoctorInterface> list = new ArrayList<DoctorInterface>();

	public Secretary() {
		for (User user : new UserMapper().getAllUser()) {
			if ("doctor".equals(user.getType())) {
				Doctor observer = new Doctor(user.getUsername());
				registerDoctor(observer);
			}
		}
	}

	public void scheduleConsultation(Consultation consultation) {
		Patient patient = new PatientMapper().getPatient(consultation.getCnp());
		ConsultationMapper consulationMapper = new ConsultationMapper();
		consulationMapper.addConsultation(consultation);
		String message = "You have a consultation for patient "
				+ patient.getNamePatient();
		notifyDoctor(consultation.getNameDoctor(), message);
	}

	@Override
	public void registerDoctor(DoctorInterface doctor) {
		list.add(doctor);
	}

	@Override
	public void unregisterDoctor(DoctorInterface doctor) {
		list.remove(doctor);
	}

	@Override
	public void notifyDoctor(String doctorUsername, String message) {
		for (DoctorInterface doctor : list) {
			if (doctorUsername.equals(doctor.getUsername())) {
				Doctor doctorImpl = (Doctor) doctor;
				doctorImpl.notifyDoctor(doctorUsername, message);
			}
		}
	}

}

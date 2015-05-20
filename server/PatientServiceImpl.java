package server;

import java.util.List;

import javax.jws.WebService;

import database.Patient;
import database.PatientMapper;

@WebService(endpointInterface = "server.PatientServiceInterface")
public class PatientServiceImpl implements PatientServiceInterface {

	@Override
	public Patient[] getAllPatients() {
		PatientMapper patientMapper = new PatientMapper();
		List<Patient> patients = patientMapper.getAllPatients();
		return patients.toArray(new Patient[patients.size()]);

	}

	@Override
	public void addPatient(Patient patient) {
		PatientMapper patientMapper = new PatientMapper();
		patientMapper.addPatient(patient);
	}

	@Override
	public void updatePatient(Patient patient) {
		PatientMapper patientMapper = new PatientMapper();
		patientMapper.updatePatient(patient);
	}

	@Override
	public void deletePatient(String cnp) {
		PatientMapper patientMapper = new PatientMapper();
		patientMapper.deletePatient(cnp);
	}
}

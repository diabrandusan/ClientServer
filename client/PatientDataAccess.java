package client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import server.PatientServiceInterface;
import database.Patient;

public class PatientDataAccess {

	public List<Patient> getAllPatients() throws MalformedURLException {
		URL wsdlUrl = new URL("http://localhost:8888/webservice/patient?wsdl");
		QName qname = new QName("http://server/", "PatientServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		PatientServiceInterface serviceInterface = service
				.getPort(PatientServiceInterface.class);
		Patient[] patients = serviceInterface.getAllPatients();
		return Arrays.asList(patients);
	}

	public void addPatient(Patient patient) throws MalformedURLException {
		URL wsdlUrl = new URL("http://localhost:8888/webservice/patient?wsdl");
		QName qname = new QName("http://server/", "PatientServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		PatientServiceInterface serviceInterface = service
				.getPort(PatientServiceInterface.class);
		serviceInterface.addPatient(patient);
	}

	public void updatePatient(Patient patient) throws MalformedURLException {
		URL wsdlUrl = new URL("http://localhost:8888/webservice/patient?wsdl");
		QName qname = new QName("http://server/", "PatientServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		PatientServiceInterface serviceInterface = service
				.getPort(PatientServiceInterface.class);
		serviceInterface.updatePatient(patient);
	}

	public void deletePetient(String cnp) throws MalformedURLException {
		URL wsdlUrl = new URL("http://localhost:8888/webservice/patient?wsdl");
		QName qname = new QName("http://server/", "PatientServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		PatientServiceInterface serviceInterface = service
				.getPort(PatientServiceInterface.class);
		serviceInterface.deletePatient(cnp);
	}
}

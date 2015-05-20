package client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import server.ConsultationServiceInterface;
import database.Consultation;

public class ConsultationDataAccess {

	public List<Consultation> getAllConsultation() throws MalformedURLException {
		URL wsdlUrl = new URL(
				"http://localhost:8888/webservice/consultation?wsdl");
		QName qname = new QName("http://server/",
				"ConsultationServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		ConsultationServiceInterface serviceInterface = service
				.getPort(ConsultationServiceInterface.class);
		Consultation[] consultations = serviceInterface.getAllConsultation();
		return Arrays.asList(consultations);
	}

	public void addConsultation(Consultation consultation)
			throws MalformedURLException {
		URL wsdlUrl = new URL(
				"http://localhost:8888/webservice/consultation?wsdl");
		QName qname = new QName("http://server/",
				"ConsultationServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		ConsultationServiceInterface serviceInterface = service
				.getPort(ConsultationServiceInterface.class);
		serviceInterface.addConsultation(consultation);
	}

	public void updateConsultation(Consultation consultation)
			throws MalformedURLException {
		URL wsdlUrl = new URL(
				"http://localhost:8888/webservice/consultation?wsdl");
		QName qname = new QName("http://server/",
				"ConsultationServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		ConsultationServiceInterface serviceInterface = service
				.getPort(ConsultationServiceInterface.class);
		serviceInterface.updateConsultation(consultation);
	}

	public void deleteConsultation(int idConsultation)
			throws MalformedURLException {
		URL wsdlUrl = new URL(
				"http://localhost:8888/webservice/consultation?wsdl");
		QName qname = new QName("http://server/",
				"ConsultationServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		ConsultationServiceInterface serviceInterface = service
				.getPort(ConsultationServiceInterface.class);
		serviceInterface.deleteConsultation(idConsultation);
	}
}

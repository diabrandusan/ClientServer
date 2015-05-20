package server;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/webservice/patient",
				new PatientServiceImpl());
		Endpoint.publish("http://localhost:8888/webservice/consultation",
				new ConsultationServiceImpl());
		Endpoint.publish("http://localhost:8888/webservice/user",
				new UserServiceImpl());
		Endpoint.publish("http://localhost:8888/webservice/notification",
				new NotificationServiceImpl());

	}
}

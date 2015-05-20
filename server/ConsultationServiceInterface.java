package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import database.Consultation;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ConsultationServiceInterface {

	@WebMethod
	public Consultation[] getAllConsultation();

	@WebMethod
	public void addConsultation(Consultation consultation);

	@WebMethod
	public void deleteConsultation(int idConsultation);

	@WebMethod
	public void updateConsultation(Consultation consultation);

}

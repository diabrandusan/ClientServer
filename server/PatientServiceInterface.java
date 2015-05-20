package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import database.Patient;

@WebService
@SOAPBinding(style = Style.RPC)
public interface PatientServiceInterface {

	@WebMethod
	public Patient[] getAllPatients();

	@WebMethod
	public void addPatient(Patient patient);

	@WebMethod
	public void deletePatient(String cnp);

	@WebMethod
	public void updatePatient(Patient patient);

}

package server;

import java.util.List;

import javax.jws.WebService;

import database.Consultation;
import database.ConsultationMapper;
import database.notification.Secretary;

@WebService(endpointInterface = "server.ConsultationServiceInterface")
public class ConsultationServiceImpl implements ConsultationServiceInterface {

	@Override
	public Consultation[] getAllConsultation() {
		ConsultationMapper consultationMapper = new ConsultationMapper();
		List<Consultation> consultation = consultationMapper
				.getAllConsultation();
		return consultation.toArray(new Consultation[consultation.size()]);

	}

	@Override
	public void addConsultation(Consultation consultation) {
		new Secretary().scheduleConsultation(consultation);
	}

	@Override
	public void updateConsultation(Consultation consultation) {
		ConsultationMapper consultationMapper = new ConsultationMapper();
		consultationMapper.updateConsultation(consultation);
	}

	@Override
	public void deleteConsultation(int idConsultation) {
		ConsultationMapper consultationMapper = new ConsultationMapper();
		consultationMapper.deleteConsultation(idConsultation);
	}

}

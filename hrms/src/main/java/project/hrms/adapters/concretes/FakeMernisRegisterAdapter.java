package project.hrms.adapters.concretes;

import java.rmi.RemoteException;

import project.hrms.adapters.abstracts.FakeCandidateMernisService;
import project.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class FakeMernisRegisterAdapter implements FakeCandidateMernisService{

	@Override
	public boolean checkEntryPerson(Candidate candidate) {
		return true;
	}

}

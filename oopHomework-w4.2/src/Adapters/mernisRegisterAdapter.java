package Adapters;

import java.rmi.RemoteException;

import Abstracts.CustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class mernisRegisterAdapter implements CustomerCheckService {

	
	@Override
	public boolean checkEntryPerson(Customer customer) {
		KPSPublicSoap client = new KPSPublicSoapProxy();

		try {
			return client.TCKimlikNoDogrula(
					Long.parseLong(customer.getNationalityID()),
					customer.getName().toUpperCase(),
					customer.getName().toUpperCase(),
					customer.getDateOfBirth().getYear()
					);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}

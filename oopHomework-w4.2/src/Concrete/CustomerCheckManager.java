package Concrete;

import Abstracts.CustomerCheckService;
import Entities.Customer;

public class CustomerCheckManager implements CustomerCheckService {

	@Override
	public boolean checkEntryPerson(Customer customer) {
		return true;
	}

}

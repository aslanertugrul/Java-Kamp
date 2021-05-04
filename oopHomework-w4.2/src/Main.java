import java.time.LocalDate;

import Abstracts.BaseCustomerManager;
import Adapters.mernisRegisterAdapter;
import Entities.Customer;
import Concrete.StarbucksCustomerManager;


public class Main {

	public static void main(String[] args) {
		
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new mernisRegisterAdapter());
		Customer customer = new Customer();
		customer.setDateOfBirth(LocalDate.of(1994, 7, 12));
		customer.setName("Ertugrul");
		customer.setSurname("Aslan");
		customer.setNationalityID("15263884366");
		
		customerManager.save(customer);

	}

}

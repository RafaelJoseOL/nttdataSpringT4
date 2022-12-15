package com.nttdata.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.persistence.Customer;
import com.nttdata.spring.services.CustomerManagementImpl;

/**
 * Taller Spring - 4
 * 
 * Clase principal
 * 
 * @author Rafael José
 *
 */
@SpringBootApplication
public class NTTDataMain implements CommandLineRunner {

	@Autowired
	CustomerManagementImpl customerService;

	/**
	 * 
	 * Metodo principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	public void run(String... args) throws Exception {

		// Constantes
		final String RAFAELJOSE = "Rafael Jose";
		final String EDUARDO = "Eduardo";
		final String PEREZMARTINEZ = "Perez Martinez";

		// Creación de clientes
		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		Customer customer3 = new Customer();
		Customer customer4 = new Customer();
		Customer customer5 = new Customer();
		customerService.createCustomer(customer1, RAFAELJOSE, "Ossorio Lopez", "09-06-1994", "11223344A");
		customerService.createCustomer(customer2, RAFAELJOSE, "Osorio Lopez", "15-01-2001", "22558877E");
		customerService.createCustomer(customer3, EDUARDO, PEREZMARTINEZ, "18-07-1998", "35789514D");
		customerService.createCustomer(customer4, "Pedro", "Soria Nuñez", "26-12-1978", "95784531F");
		customerService.createCustomer(customer5, EDUARDO, PEREZMARTINEZ, "01-10-1991", "44532783N");
		customerService.addCustomer(customer1);
		customerService.addCustomer(customer2);
		customerService.addCustomer(customer3);
		customerService.addCustomer(customer4);
		customerService.addCustomer(customer5);
	}
}
package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.nttdata.spring.persistence.Customer;
import com.nttdata.spring.repository.CustomerRepositoryI;

/**
 * Taller Spring - 4
 * 
 * Implementacion de Cliente
 * 
 * @author Rafael José
 *
 */

@Service("customer")
@Primary
public class CustomerManagementImpl implements CustomerManagementI {

	@Autowired
	CustomerRepositoryI customerRepo;

	@Override
	public void createCustomer(Customer customer, String name, String lastName, String birthDate, String document) {
		customer.setCustomerName(name);
		customer.setCustomerLastName(lastName);
		customer.setBirthDate(birthDate);
		customer.setDocument(document);
	}

	@Override
	public void addCustomer(Customer customer) {
		customerRepo.save(customer);
	}
	
	@Override
	public void deleteCustomer(Customer customer) {
		customerRepo.delete(customer);
	}
	
	@Override
	public List<Customer> findAll() {
		return customerRepo.findAll();
	}

	@Override
	public List<Customer> findByCustomerName(String customerName) {
		return customerRepo.findByCustomerName(customerName);
	}

	@Override
	public List<Customer> findByCustomerNameAndCustomerLastName(String customerName, String customerLastName) {
		return customerRepo.findByCustomerNameAndCustomerLastName(customerName, customerLastName);
	}

	@Override
	public List<Customer> findByCustomerNameAndCustomerLastNameAndDocument(String customerName, String customerLastName,
			String document) {
		return customerRepo.findByCustomerNameAndCustomerLastNameAndDocument(customerName, customerLastName, document);
	}
}

package com.nttdata.spring.services;

import java.util.List;

import com.nttdata.spring.persistence.Customer;

/**
 * Taller Spring - 4
 * 
 * Interfaz - Cliente
 * 
 * @author Rafael José
 *
 */
public interface CustomerManagementI {

	// Métodos para implementar.
	public void createCustomer(Customer customer, String name, String lastName, String birthDate, String document);

	public void addCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);
	
	public List<Customer> findAll();

	public List<Customer> findByCustomerName(final String customerName);

	public List<Customer> findByCustomerNameAndCustomerLastName(final String customerName,
			final String customerLastName);

	public List<Customer> findByCustomerNameAndCustomerLastNameAndDocument(final String customerName,
			final String customerLastName, final String document);
}

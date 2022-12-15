package com.nttdata.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.spring.persistence.Customer;

/**
 * Taller Spring - 4
 * 
 * Repositorio de clientes.
 * 
 * @author Rafael José
 *
 */

@Repository
public interface CustomerRepositoryI extends JpaRepository<Customer, Long> {

	/**
	 * Búsqueda de clientes por su nombre.
	 * 
	 * @param customerName
	 * @return List<Customer>
	 */
	public List<Customer> findByCustomerName(final String customerName);

	/**
	 * Búsqueda de clientes por su nombre completo.
	 * 
	 * @param customerName
	 * @param customerLastName
	 * @return List<Customer>
	 */
	public List<Customer> findByCustomerNameAndCustomerLastName(final String customerName,
			final String customerLastName);
	
	/**
	 * Búsqueda de clientes por su nombre completo y DNI.
	 * 
	 * @param customerName
	 * @param customerLastName
	 * @param customerDocument
	 * @return List<Customer>
	 */
	public List<Customer> findByCustomerNameAndCustomerLastNameAndDocument(final String customerName,
			final String customerLastName, final String document);
}

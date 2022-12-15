package com.nttdata.spring.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Taller Spring - 4
 * 
 * Tabla Cliente.
 * 
 * @author Rafael José
 *
 */

@Entity
@Table(name = "NTTDATA_T4_CUSTOMER")
public class Customer implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long customerId;

	/** Nombre del cliente */
	private String customerName;

	/** Apellidos del cliente */
	private String customerLastName;

	/** Fecha de nacimiento */
	private String birthDate;	

	/** DNI */
	private String document;

	/**
	 * @return customerId
	 */
	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_Sequence")
	@SequenceGenerator(name = "customer_id_Sequence", sequenceName = "CUSTOMER_ID_SEQ")
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId to be set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return customerName
	 */
	@Column(name = "CUSTOMER_NAME")
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName to be set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return customerLastName
	 */
	@Column(name = "CUSTOMER_LAST_NAME")
	public String getCustomerLastName() {
		return customerLastName;
	}

	/**
	 * @param customerLastName to be set
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	/**
	 * @return birthDate
	 */
	@Column(name = "CUSTOMER_BIRTH_DATE")
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate to be set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return document
	 */
	@Column(name = "CUSTOMER_DOCUMENT")
	public String getDocument() {
		return document;
	}

	/**
	 * @param document to be set
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return "Customer: \nCustomer Id:" + customerId + "\nCustomer name:" + customerName + "\nCustomer last name:"
				+ customerLastName + "\nBirth date:" + birthDate + "\nDocument:" + document + "]";
	}
}

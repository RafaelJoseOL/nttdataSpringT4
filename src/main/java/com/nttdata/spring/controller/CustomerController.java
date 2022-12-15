package com.nttdata.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.spring.persistence.Customer;
import com.nttdata.spring.services.CustomerManagementImpl;

@Controller
public class CustomerController {

	@Autowired
	CustomerManagementImpl customerService;
	static final String CUSTOMERS = "customers";
	static final String LIST_OF_CUSTOMERS = "listOfCustomers";
	
	/**
	 * Metodo para abrir el formulario de nuevo cliente
	 * @param model
	 * @return
	 */
	@RequestMapping("/newCustomer")
	public String newCustomer(Model model) {
		return "newCustomerForm";
	}

	/**
	 * Metodo para registrar un cliente en el registro
	 * @param customer
	 * @param model
	 * @param bRes
	 * @return
	 */
	@RequestMapping("/registerNewCustomer")
	public String registerCustomer(@ModelAttribute("customer") Customer customer, Model model, BindingResult bRes) {
		customerService.addCustomer(customer);
		return "newCustomerForm";
	}

	/**
	 * Metodo para mostrar todos los clientes
	 * @param model
	 * @return
	 */
	@RequestMapping("/showCustomers")
	public String listOfCustomers(Model model) {
		model.addAttribute(CUSTOMERS, customerService.findAll());
		return LIST_OF_CUSTOMERS;
	}

	/**
	 * Metodo para acceder a la busqueda de clientes por nombre
	 * @return
	 */
	@RequestMapping("/toSearchCustomerByName")
	public String toSearchCustomerByName() {
		return "/searchCustomerByName";
	}

	/**
	 * Metodo para buscar por nombre
	 * @param customerName
	 * @param model
	 * @return
	 */
	@RequestMapping("/searchCustomerByName")
	public String searchCustomerByName(@RequestParam String customerName, Model model) {
		model.addAttribute(CUSTOMERS, customerService.findByCustomerName(customerName));
		return LIST_OF_CUSTOMERS;
	}
	
	/**
	 * Metodo para acceder a la busqueda de clientes por nombre completo
	 * @return
	 */
	@RequestMapping("/toSearchCustomerByFullName")
	public String toSearchCustomerByFullName() {
		return "/searchCustomerByFullName";
	}

	/**
	 * Metodo para buscar por nombre completo
	 * @param customerName
	 * @param customerLastName
	 * @param model
	 * @return
	 */
	@RequestMapping("/searchCustomerByFullName")
	public String searchCustomerByFullName(@RequestParam String customerName, @RequestParam String customerLastName,
			Model model) {
		model.addAttribute(CUSTOMERS,
				customerService.findByCustomerNameAndCustomerLastName(customerName, customerLastName));
		return LIST_OF_CUSTOMERS;
	}

	/**
	 * Metodo para acceder a la busqueda de clientes por nombre completo y DNI
	 * @return
	 */
	@RequestMapping("/toSearchCustomerByFullNameAndDocument")
	public String toSearchCustomerByFullNameAndDocument() {
		return "/searchCustomerByFullNameAndDocument";
	}

	/**
	 * Metodo para buscar por nombre completo y DNI
	 * @param customerName
	 * @param customerLastName
	 * @param document
	 * @param model
	 * @return
	 */
	@RequestMapping("/searchCustomerByFullNameAndDocument")
	public String searchCustomerByFullNameAndDocument(@RequestParam String customerName,
			@RequestParam String customerLastName, String document, Model model) {
		model.addAttribute(CUSTOMERS, customerService.findByCustomerNameAndCustomerLastNameAndDocument(customerName,
				customerLastName, document));
		return LIST_OF_CUSTOMERS;
	}

	/**
	 * Metodo para mostrar pantalla de error
	 * @param res
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	public String checkExceptions(BindingResult res) {

		String output = "";
		if (res.hasErrors()) {
			output = "/showErrorView";
		}
		return output;
	}
}

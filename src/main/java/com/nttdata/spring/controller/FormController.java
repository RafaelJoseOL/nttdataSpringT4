package com.nttdata.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	
	/**
	 * Pagina a abrir por defecto
	 * @return
	 */
	@RequestMapping("/*")
	public String firstPage() {
		return "newCustomerForm";
	}
}

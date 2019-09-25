package com.estafet.microservices.scrum.basic.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dennis Williams, Estafet Ltd.
 *
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

	@GetMapping("/503")
	public String error503() {
		return "error503";
	}
}

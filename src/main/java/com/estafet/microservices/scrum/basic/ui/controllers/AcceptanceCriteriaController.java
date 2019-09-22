package com.estafet.microservices.scrum.basic.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.estafet.microservices.scrum.basic.ui.model.AcceptanceCriterion;
import com.estafet.microservices.scrum.basic.ui.service.StoryService;

/**
 * @author Dennis Williams, Estafet Ltd.
 *
 */
@Controller
public class AcceptanceCriteriaController {

	/**
	 * The story service.
	 */
	@Autowired
	private StoryService storyService;

	@GetMapping("/story/{id}/criteria")
	public String criteriaForm(@PathVariable final int id,  final Model model) {
		model.addAttribute("criteria", new AcceptanceCriterion().init());
		model.addAttribute("storyId", id);
		return "criteria";
	}

	@PostMapping("/story/{id}/criteria")
	public String criteriaSubmit(@PathVariable final int id, @ModelAttribute final AcceptanceCriterion criteria) {
		storyService.addAcceptanceCriteria(id, criteria);
		return "redirect:/story/" + id;
	}

}


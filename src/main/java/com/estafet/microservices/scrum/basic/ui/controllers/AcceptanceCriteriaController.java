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

	/**
	 * Get the mapping for the given story Id.
	 *
	 * <p>The {@link GetMapping} annotation maps HTTP {@code GET} "{@code /story/{id}/criteria}" requests onto this
	 * method.</p>
	 * @param id
	 *         The story Id.
	 * @param model
	 *         The attributes for the criteria page.
	 * @return
	 *         The name of the criteria page, "@code criteria}" : {@code src/main/resources/templates/criteria.html}
	 *
	 */
	@GetMapping("/story/{id}/criteria")
	public String criteriaForm(@PathVariable final int id,  final Model model) {

	    // Add the attributes for the {criteria} and {storyId}.
		model.addAttribute("criteria", new AcceptanceCriterion().init());
		model.addAttribute("storyId", Integer.valueOf(id));
		return "criteria";
	}

	/**
	 * Create the POST request.
	 * @param id
	 *         The story Id.
	 * @param criteria
	 *         The acceptance criteria.
	 * @return
	 *         A redirect request (when {@code id} is {@code 999}) to "{@code /story/999}."
	 */
	@PostMapping("/story/{id}/criteria")
	public String criteriaSubmit(@PathVariable final int id, @ModelAttribute final AcceptanceCriterion criteria) {

	    // Send REST request to the story service. Returns a com.estafet.microservices.scrum.basic.ui.model.Story
	    // object, which is not used here.
		storyService.addAcceptanceCriteria(id, criteria);
		return "redirect:/story/" + id;
	}

}


package com.estafet.microservices.scrum.basic.ui.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ProjectPage extends Page {
	
	@FindBys({
	    @FindBy(partialLinkText = "Story #")
	})
	@CacheLookup
	List<WebElement> storyLinks;
	
	@FindBy(linkText = "Project Burndown")
	@CacheLookup
	WebElement projectBurndownLink;
	
	@FindBy(linkText = "Sprint Burndown")
	@CacheLookup
	WebElement sprintBurndownLink;
	
	@FindBy(partialLinkText = "Sprint #")
	@CacheLookup
	WebElement activeSprintLink;
	
	@FindBy(linkText = "Add Story")
	@CacheLookup
	WebElement addStoryLink;
	
	@FindBy(linkText = "Projects")
	@CacheLookup
	WebElement projectsBreadcrumbLink;
	
	@FindBy(linkText = "Project")
	@CacheLookup
	WebElement projectBreadcrumbLink;
	
	public ProjectPage(String projectId) {
		super(projectId);
	}

	public ProjectPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String uri() {
		return "/project/{1}";
	}
	
	public List<String> getStories() {
		return getTextList(storyLinks);
	}
	
	public StoryPage storyPage(String story) {
		return click(story, storyLinks, StoryPage.class);
	}
	
	public SprintPage activeSprint() {
		return click(activeSprintLink, SprintPage.class);
	}

	public AddStoryPage addStoryPage() {
		return click(addStoryLink, AddStoryPage.class);
	}
	
	public ProjectBurndownPage projectBurndownPage() {
		return click(projectBurndownLink, ProjectBurndownPage.class);
	}
	
	public SprintBurndownPage sprintBurndownPage() {
		return click(sprintBurndownLink, SprintBurndownPage.class);
	}
	
	public ProjectsPage projectsBreadCrumb() {
		return click(projectsBreadcrumbLink, ProjectsPage.class);
	}
	
	public ProjectPage projectBreadCrumb() {
		return click(projectBreadcrumbLink, ProjectPage.class);
	}
	
}

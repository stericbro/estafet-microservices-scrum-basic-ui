package com.estafet.microservices.scrum.basic.ui.selenium.tests;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.estafet.microservices.scrum.lib.selenium.pages.story.StoryPage;

public class ITStoryPageTest {

    StoryPage storyPage;

    @Before
    public void before() {
        storyPage = new StoryPage("3");
    }

    @After
    public void after() {
        storyPage.close();
    }

    @Test
    public void testViewTasks() {
        assertThat(storyPage.getTasks().size(), is(3));
        assertThat(storyPage.getTasks().get(0), is("Task #6999"));
        assertThat(storyPage.getTasks().get(1), is("Task #9305"));
        assertThat(storyPage.getTasks().get(2), is("Task #6329"));
    }

    @Test
    public void testViewAcceptanceCriteria() {
        assertThat(storyPage.getAcceptanceCriteria().size(), is(3));
        assertThat(storyPage.getAcceptanceCriteria().get(0), is("Acceptance #8261"));
        assertThat(storyPage.getAcceptanceCriteria().get(1), is("Acceptance #2165"));
        assertThat(storyPage.getAcceptanceCriteria().get(2), is("Acceptance #1162"));
    }

    @Test
    public void testClickProjectsBreadCrumb() {
        assertTrue(storyPage.clickProjectsBreadCrumbLink().isLoaded());
    }

    @Test
    public void testClickProjectBreadCrumb() {
        assertTrue(storyPage.clickProjectBreadCrumbLink().isLoaded("2"));
    }

    @Test
    public void testStatus() {
        assertThat(storyPage.getStatus(), is("Not Started"));
    }

    @Test
    public void testName() {
        assertThat(storyPage.getName(), is("Story #6482"));
    }

    @Test
    public void testClickAddTask() {
        assertTrue(storyPage.clickAddTaskLink().isLoaded("3"));
    }

    @Ignore
    @Test
    public void testClickAddCriteria() {
        assertTrue(storyPage.clickAddCriteriaLink().isLoaded("3"));
    }

}

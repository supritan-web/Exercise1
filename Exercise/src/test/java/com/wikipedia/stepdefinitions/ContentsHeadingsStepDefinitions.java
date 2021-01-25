package com.wikipedia.stepdefinitions;

import com.wikipedia.pages.ContentsHeadingsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;



public class ContentsHeadingsStepDefinitions {
	
	@Steps
	ContentsHeadingsPage contentsHeadingsPage;
	
	@Given("user is on Wikipedia page")
	public void user_is_on_Wikipedia_page() {
	    
		contentsHeadingsPage.launchApplication();
	 
	}

	@When("lists contents box")
	public void lists_contents_box() {
	    
		contentsHeadingsPage.list();
	   
	}

	@Then("lists are headings on the page")
	public void lists_are_headings_on_the_page() {
		contentsHeadingsPage.validatelistHeadings();
		
	}
	
	@Then("lists are clickable")
	public void lists_are_clickable() {
		contentsHeadingsPage.validatelistClickable();
	}
	
	@When("user hovers over Nike")
	public void user_hovers_over_Nike() {
		contentsHeadingsPage.personifiedConcepts();
	}

	@Then("validate personified concepts")
	public void validate_personified_concepts() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}

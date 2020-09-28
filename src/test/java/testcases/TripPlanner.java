package testcases;

import org.testng.annotations.Test;
import config.KnowledgeBase;
import testBase.lib;


/* This Test Cases class is used to provide the proof of Concept as the Scenario given below */
/* Planning a trip between 2 stations using Trip Planner*/

//Note: The TripPlanner class has a parent class as lib, which has the Driver reference, as well as the URL of the Trip Planner.
public class TripPlanner extends lib {	
		
		//The KnowledgeBase has all the required Test data of From and To locations, as well as the Xpaths maintained//
		KnowledgeBase kb = new KnowledgeBase();
		
		// The First Test to execute trip request in the Trip planner web application//
		@Test(priority =1)
		public void tripPlanning() throws InterruptedException {
			Thread.sleep(3000);
			
			kb.EnterFromLocation(); //This method deals with the From location in the Trip Planner.
						
			kb.EnterToLocation();	//This method deals with the To location in the Trip Planner.
			
			kb.ClickOutsideOfLocations();	//This method is used to merely take the driver reference out of the To location.					
			
		};
		
		
		// This Test is executed to scroll down to see the list, once the above test is executed successfully.
		// It's implementation depends on the First test, wherein if fails, if the above test is not executed successfully.
		@Test(dependsOnMethods= "tripPlanning")
		public void scrollingForResults() throws InterruptedException {
			kb.SearchForTripsLaterButton();			
			
		};
			
		

	}



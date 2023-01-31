package com.cmrwebstudio.beer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cmrwebstudio.ComponentScanMarker;
/**
 * Beer Buddy World Beer Guide
 * A REST API
 * @author cmrapp / cmrwebstudio
 * created January 2023
 * 
 * This API reads from a database (named beer) that was hand created for this project.
 * The tables in the database are: beer, brewery, category, flavor and flavor_profile
 * 
 * Database Table Contents:
 * BEER: 	 beer_pk	beer_name	brewery_id (FK)	  category    flavor    abv   ibu  description
 * BREWERY:  brewery_pk   name   country   website
 * CATEGORY: category_pk   name   description
 * FLAVOR:	 flavor_pk   name
 * FLAVOR_PROFILE (Join table)   beer_pk   flavor_pk
 * 
 * The API has the following  functionalities:
 * 
 * ----- GET REQUESTS ---------------
 * - view beers by an id
 * - view a description of a category
 * - view brewer information
 * - view beers by category
 * 
 * ----- PUT REQUESTS ---------------
 * - add tasting notes (flavor_profile) to a specific
 * - delete a beer from the database
 */


/** The main method uses the SpringBootApplication annotation and calls the run method
 *  to start the application. Also calls the displaySplashScreen method which displays
 *  a splash screen in the console window.
 */

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})

public class BeerBuddy {

	public static void main(String[] args) {
		SpringApplication.run(BeerBuddy.class, args);	
		displaySplashScreen();
	}

	

	static void displaySplashScreen() {
		// @formatter:off
		System.out.println("*****************************************************************");
		System.out.println("*                                                               *");
		System.out.println("*                 BBBBB   EEEEE   EEEEE   RRRRR                 *");
		System.out.println("*                 BB  B   EE      EE      R   R                 *");
		System.out.println("*                 BBBB    EEEE    EEEE    RRRR                  *");
		System.out.println("*                 BB  B   EE      EE      RR  R                 *");
		System.out.println("*                 BBBBB   EEEEE   EEEE    RR  R                 *");
		System.out.println("*                                                               *");
		System.out.println("*                         B  U  D  D  Y                         *");
		System.out.println("*                             v2.6                              *");
		System.out.println("*                                                               *");
		System.out.println("*                        by cmrwebstudio                        *");
		System.out.println("*                                                               *");
		System.out.println("*                     This one's for Dr Rob!                    *");
		System.out.println("*                                                               *");
		System.out.println("*  'Beer is proof that God loves us and wants us to be happy.'  *");
		System.out.println("*                    - Benjamin Franklin                        *");
		System.out.println("*                                                               *");
		System.out.println("*****************************************************************");
		// @formatter:on
	}
	
}


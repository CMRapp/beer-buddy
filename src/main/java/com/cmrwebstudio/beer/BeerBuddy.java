package com.cmrwebstudio.beer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cmrwebstudio.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })

public class BeerBuddy {

	public static void main(String[] args) {
		SpringApplication.run(BeerBuddy.class, args);	
		displaySplashScreen();
	}

	static void displaySplashScreen() {
		// @formatter:off
		System.out.println("***************************************");
		System.out.println("*                                     *");
		System.out.println("*    BBBBB   EEEEE   EEEEE   RRRRR    *");
		System.out.println("*    BB  B   EE      EE      R   R    *");
		System.out.println("*    BBBB    EEEE    EEEE    RRRR     *");
		System.out.println("*    BB  B   EE      EE      RR  R    *");
		System.out.println("*    BBBBB   EEEEE   EEEE    RR  R    *");
		System.out.println("*                                     *");
		System.out.println("*            B  U  D  D  Y            *");
		System.out.println("*                                     *");
		System.out.println("*           by cmrwebstudio           *");
		System.out.println("*                                     *");
		System.out.println("*        This one's for Dr Rob!       *");
		System.out.println("*                                     *");
		System.out.println("* app data provided by openbeerdb.com *");
		System.out.println("***************************************");
		// @formatter:on
	}
	
}


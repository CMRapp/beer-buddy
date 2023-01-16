package com.cmrwebstudio.beer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.cmrwebstudio.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })

public class BeerBuddy {

	public static void main(String[] args) {
		SpringApplication.run(BeerBuddy.class, args);

	}

}

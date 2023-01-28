package com.cmrwebstudio.beer.entity;

import java.util.Comparator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Beer implements Comparable<Beer> {
	@NotNull
	@Positive
	private int beerId;		// primary key
	
	@NotNull
	@Positive
	private int breweryId;	// foreign key
	
	@NotNull
	@Length(max=50)
	@Pattern(regexp = "[\\w\\s]*")
	private String beerName;
	
	@NotNull
	private Category category;
	
	@Positive
	private double abv;
	
	@Positive
	private int ibu;
	
	@NotNull
	private String beerDesc;
	

	@Override
	public int compareTo(Beer that) {
		return Comparator
				.comparing(Beer::getBeerId)
				.compare(this,  that);
	}
	
}

package com.cmrwebstudio.beer.entity;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Beer implements Comparable<Beer> {
	private int beer_id;
	private int brewery_id;
	private String name;
	private int category_id;
	private int style_id;
	private double abv;
	private double ibu;
	private String beer_desc;
	private int flavor_profile;
	

	@Override
	public int compareTo(Beer that) {
		return Comparator
				.comparing(Beer::getBeer_id)
				.compare(this,  that);
	}
	
}

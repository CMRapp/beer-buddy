package com.cmrwebstudio.beer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Beer {
	private int beer_id;
	private int brewery_id;
	private String name;
	private int category_id;
	private int style_id;
	private double abv;
	private double ibu;
	private String beer_desc;
	private int flavor_profile;
	
}

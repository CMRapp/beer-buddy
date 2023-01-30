package com.cmrwebstudio.beer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CatDescription {
	private int catId;
	private String catName;
	private String catDesc;
}

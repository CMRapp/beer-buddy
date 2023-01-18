package com.cmrwebstudio.beer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

	public class Style {
		private int styleId;
		private int categoryId; //foreign key
		private String styleName;
}

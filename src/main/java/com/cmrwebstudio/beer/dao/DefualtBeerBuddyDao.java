package com.cmrwebstudio.beer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;
import com.cmrwebstudio.beer.entity.Flavor;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefualtBeerBuddyDao implements BeerBuddyDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Beer> fetchBeers(Category category, Flavor flavor) {
		log.debug("DAO: category = {} and flavor = {}", category, flavor);
		
		// @formatter: off
		String sql = ""
			+ "SELECT * "
			+ "FROM beers "
			+ "WHERE beer_id = :beer_id";
		// @formatter: on
		
		Map<String, Object> params = new HashMap<>();
		params.put("category", category);
		params.put("flavor", flavor);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

		@Override
		public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter: off
			return Beer.builder()
				.beerId(rs.getInt("beer_id"))
				.breweryId(rs.getInt("brewery_id"))
				.name(rs.getString("name"))
				.categoryId(Category.valueOf(rs.getString("category_id")))
				.styleId(rs.getInt("style_id"))
				.abv(rs.getDouble("abv"))
				.ibu(rs.getDouble("ibu"))
				.flavorProfile(Flavor.valueOf(rs.getString("flavor_profile")))
				.build();
			// @formatter:on
			}});
	}

}

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

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefualtBeerBuddyDao implements BeerBuddyDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Beer> fetchBeers(int beer_id) {
		log.debug("DAO: beer_id = {}", beer_id);
		
		// @formatter: off
		String sql = ""
			+ "SELECT * "
			+ "FROM beers "
			+ "WHERE beer_id = :beer_id";
		// @formatter: on
		
		Map<String, Object> params = new HashMap<>();
		params.put("beer_id", beer_id);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

		@Override
		public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter: off
			return Beer.builder()
				.beer_id(rs.getInt("beer_id"))
				.brewery_id(rs.getInt("brewery_id"))
				.name(rs.getString("name"))
				.category_id(rs.getInt("category_id"))
				.style_id(rs.getInt("style_id"))
				.abv(rs.getDouble("abv"))
				.ibu(rs.getDouble("ibu"))
				.flavor_profile(rs.getInt("flavor_profile"))
				.build();
			// @formatter:on
			}});
	}

}

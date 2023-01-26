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
import com.cmrwebstudio.beer.entity.Breweries;
import com.cmrwebstudio.beer.entity.CatDescription;
import com.cmrwebstudio.beer.entity.Category;
import com.cmrwebstudio.beer.entity.Reviews;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefualtBeerBuddyDao implements BeerBuddyDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Beer> fetchBeers(Category category) {
		log.debug("DAO: category = {} ", category);
		// @formatter: off
				
		String sql = ""
			+ "SELECT * "
			+ "FROM beers "
			+ "WHERE category = :category";
		// @formatter: on
		
				
		Map<String, Object> params = new HashMap<>();
		params.put("category", category.toString());
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

		@Override
		public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter: off
			return Beer.builder()
				.beerId(rs.getInt("beer_pk"))
				.breweryId(rs.getInt("brewery_id"))
				.name(rs.getString("beer_name"))
				.category(Category.valueOf(rs.getString("category")))
				.abv(rs.getDouble("abv"))
				.ibu(rs.getInt("ibu"))
				.beerDesc(rs.getString("description"))
				.build();
			// @formatter:on
			}});
	}
	
	@Override
	public List<Breweries> fetchBrewery(int brewery_pk) {
		log.debug("DAO: breweryId = {}", brewery_pk);
		String sql;
		
		if(brewery_pk <= 0) {
			// @formatter: off
			sql = ""
				+ "SELECT * "
				+ "FROM brewery "
				+ "WHERE brewery_pk = brewery_pk"; 	//removing : causes all to display
			// @formatter: on
		
		} else {
			// @formatter: off
			sql = ""
				+ "SELECT * "
				+ "FROM brewery "
				+ "WHERE brewery_pk = :brewery_pk";
			// @formatter: on
		}
		
		
		Map<String, Object> params = new HashMap<>();
		params.put("brewery_pk", brewery_pk);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

		@Override
		public Breweries mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter: off
			return Breweries.builder()
				.breweryId(rs.getInt("brewery_pk"))
				.breweryName(rs.getString("name"))
				.country(rs.getString("country"))
				.website(rs.getString("website"))
				.build();
			// @formatter:on
			}});
	}

	@Override
	public List<CatDescription> fetchDescription(Category category) {
			log.debug("fetchDescription: category = {} ", category);
			System.out.println(category);
			// @formatter: off
			String cat = "'"+category.toString()+"'";
			String sql = ""
				+ "SELECT * "
				+ "FROM category "
				+ "WHERE name = " + cat;
			// @formatter: on
			
			Map<String, Object> params = new HashMap<>();
			params.put("name", category.toString());
			
			return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public CatDescription mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter: off
				return CatDescription.builder()
					.catId(rs.getInt("category_pk"))
					.name(rs.getString("name"))
					.desc(rs.getString("description"))
					.build();
				// @formatter:on
				}});
	}

	@Override
	public List<Beer> fetchBeerDetails(int beer_pk) {
		log.debug("DAO: Beer Id = {} ", beer_pk);
		// @formatter: off
			String sql = ""
			+ "SELECT * "
			+ "FROM beers "
			+ "WHERE beer_pk = :beer_pk";
		// @formatter: on
		
				
		Map<String, Object> params = new HashMap<>();
		params.put("beer_pk", beer_pk);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

		@Override
		public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter: off
			return Beer.builder()
				.beerId(rs.getInt("beer_pk"))
				.breweryId(rs.getInt("brewery_id"))
				.name(rs.getString("beer_name"))
				.category(Category.valueOf(rs.getString("category")))
				.abv(rs.getDouble("abv"))
				.ibu(rs.getInt("ibu"))
				.beerDesc(rs.getString("description"))
				.build();
			// @formatter:on
			}});
	}

	@Override
	public List<Reviews> fetchReviews(int beer_pk) {
		log.debug("DAO: Beer Id = {} ", beer_pk);
		// @formatter: off
			String sql = ""
			+ "SELECT * "
			+ "FROM reviews "
			+ "RIGHT JOIN beer_reviews on reviews.beer_pk = beer_reviews.beer_pk "
			+ "WHERE beer_reviews.beer_pk = :beer_pk "
			+ "GROUP BY reviews.review ";
		// @formatter: on
		
				
		Map<String, Object> params = new HashMap<>();
		params.put("beer_pk", beer_pk);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

		@Override
		public Reviews mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter: off
			return Reviews.builder()
				.reviewPK(rs.getInt("review_pk"))
				.beerId(rs.getInt("beer_pk"))
				.name(rs.getString("name"))
				.review(rs.getString("review"))
				.build();
			// @formatter:on
			}});
	}
}

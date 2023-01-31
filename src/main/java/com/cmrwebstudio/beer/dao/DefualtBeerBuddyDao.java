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
import com.cmrwebstudio.beer.entity.Distributor;
import com.cmrwebstudio.beer.entity.Review;

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
				.beerName(rs.getString("beer_name"))
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
					.catName(rs.getString("name"))
					.catDesc(rs.getString("description"))
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
				.beerName(rs.getString("beer_name"))
				.category(Category.valueOf(rs.getString("category")))
				.abv(rs.getDouble("abv"))
				.ibu(rs.getInt("ibu"))
				.beerDesc(rs.getString("description"))
				.build();
			// @formatter:on
			}});
	}

	@Override
	public List<Review> fetchReviews(int beer_pk) {
		log.debug("DAO: Beer Id = {} ", beer_pk);
		// @formatter: off
			String sql = ""
			+ "SELECT * "
			+ "FROM reviews "
			+ "RIGHT JOIN beer_reviews " 
			+ "ON reviews.beer_pk = beer_reviews.beer_pk "
			+ "WHERE beer_reviews.beer_pk = :beer_pk "
			+ "GROUP BY reviews.review ";
		// @formatter: on
		
				
		Map<String, Object> params = new HashMap<>();
		params.put("beer_pk", beer_pk);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

		@Override
		public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter: off
			return Review.builder()
				.reviewPk(rs.getInt("review_pk"))
				.beerId(rs.getInt("beer_pk"))
				.beerName(rs.getString("beer_name"))
				.reviewerName(rs.getString("reviewer_name"))
				.rating(rs.getInt("rating"))
				.review(rs.getString("review"))
				.build();
			// @formatter:on
			}});
	}

	@Override
	public List<Distributor> fetchDistributor(String dist_name) {
		log.debug("DAO: Dist Name = {} ", dist_name);
		// @formatter: off
			String sql = ""
			+ "SELECT * "
			+ "FROM distributors "
			+ "RIGHT JOIN distributor_list " 
			+ "ON distributors.dist_pk = distributor_list.dist_pk "
			+ "WHERE distributor_list.beer_pk = :beer_pk "
			+ "GROUP BY distributors.dist_name ";
		// @formatter: on
			Map<String, Object> params = new HashMap<>();
			params.put("dist_name", dist_name);
			
			return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Distributor mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter: off
				return Distributor.builder()
					.dist_pk(rs.getInt("dist_pk"))
					.dist_name(rs.getString("dist_name"))
					.website(rs.getString("website"))
					.build();
				// @formatter:on
				}});
		}
}

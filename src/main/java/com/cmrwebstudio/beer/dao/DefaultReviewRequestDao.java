package com.cmrwebstudio.beer.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.cmrwebstudio.beer.entity.Review;

@Component

public class DefaultReviewRequestDao implements ReviewRequestDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	
	@Override
	public Review saveReview(int beerId, String beerName, String reviewerName, int rating, String review) {
		SqlParams params = genetrateInsertSql(beerId, beerName, reviewerName, rating, review);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(params.sql,  params.source, keyHolder);
		
		int reviewPk = keyHolder.getKey().intValue();
				
		// @formatter:off
		return Review.builder()
				.reviewPk(reviewPk)
				.beerId(beerId)
				.beerName(beerName)
				.rating(rating)
				.reviewerName(reviewerName)
				.review(review)
				.build();
		// @formatter:on
	}
	
	/**
	 * 
	 * @param review
	 * @return
	 */
	private SqlParams genetrateInsertSql(int beer_pk, String beer_name, String reviewer_name, int rating, String review) {
		// @formatter:off
		String sql = ""
			+ "INSERT INTO reviews ("
			+ "beer_pk, beer_name, reviewer_name, rating, review"
			+ ") VALUES ("
			+ ":beer_pk, :beer_name, :reviewer_name, :rating, :review"
			+ ")";
		// @formatter:on

		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("beer_pk", beer_pk);
		params.source.addValue("beer_name", beer_name);
		params.source.addValue("reviewer_name", reviewer_name);
		params.source.addValue("rating", rating);
		params.source.addValue("review", review);
		
		return params;
	}


	public Optional<Review> fetchReview(int beer_pk, String beer_name) {

		String sql = ""
			+ "SELECT * "
			+ "FROM reviews "
			+ "WHERE beer_pk = :beer_pk "
			+ "AND beer_name = :beer_name"; 
		
		Map<String, Object> params = new HashMap<>();
		params.put("beer_pk", beer_pk);
		params.put("beer_name", beer_name);
		
		return Optional.ofNullable(
				jdbcTemplate.query(sql, params, new ReviewResultSetExtractor()));
	}
	
	class ReviewResultSetExtractor implements ResultSetExtractor<Review> {

		@Override
		public Review extractData(ResultSet rs) 
				throws SQLException, DataAccessException {
			rs.next();
			// @formatter: off
			return Review.builder()
					.beerId(rs.getInt("beer_pk"))
					.beerName(rs.getString("beer_name"))
					.reviewerName(rs.getString("reviewer_name"))
					.rating(rs.getInt("rating"))
					.review(rs.getString("review"))					
					.build();
			// @formatter:on
		}
		
	}
	
	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}

	
}

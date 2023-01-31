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

import com.cmrwebstudio.beer.entity.Distributor;

@Component

public class DefaultPostDistributorDao implements PostDistributorDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	
	@Override
	public Distributor saveDistributor(String distName, String website) {
		SqlParams params = genetrateInsertSql(distName, website);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(params.sql,  params.source, keyHolder);
		
		int distPk = keyHolder.getKey().intValue();
				
		// @formatter:off
		return Distributor.builder()
				.dist_pk(distPk)
				.dist_name(distName)
				.website(website)
				.build();
		// @formatter:on
	}
	
	/**
	 * 
	 * @param review
	 * @return
	 */
	private SqlParams genetrateInsertSql(String dist_name, String website) {
		// @formatter:off
		String sql = ""
			+ "INSERT INTO distributors ("
			+ "dist_name, website"
			+ ") VALUES ("
			+ ":dist_name, :website "
			+ ")";
		// @formatter:on

		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("dist_name", dist_name);
		params.source.addValue("website", website);
		
		return params;
	}


	public Optional<Distributor> fetchDistributor(String dist_name) {

		String sql = ""
			+ "SELECT * "
			+ "FROM distributors "
			+ "WHERE dist_name = :dist_name "; 
		
		Map<String, Object> params = new HashMap<>();
		params.put("dist_name", dist_name);
		
		return Optional.ofNullable(
				jdbcTemplate.query(sql, params, new ReviewResultSetExtractor()));
	}
	
	class ReviewResultSetExtractor implements ResultSetExtractor<Distributor> {

		@Override
		public Distributor extractData(ResultSet rs) 
				throws SQLException, DataAccessException {
			rs.next();
			// @formatter: off
			return Distributor.builder()
					.dist_pk(rs.getInt("dist_pk"))
					.dist_name(rs.getString("dist_name"))
					.website(rs.getString("website"))				
					.build();
			// @formatter:on
		}
		
	}
	
	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}

	

	

	
}

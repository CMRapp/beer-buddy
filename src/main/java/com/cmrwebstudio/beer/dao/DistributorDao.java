package com.cmrwebstudio.beer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.cmrwebstudio.beer.entity.Distributor;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class DistributorDao implements DistributorDaoInterface {

		@Autowired
		private NamedParameterJdbcTemplate jdbcTemplate;
	
		//returns list of distributors in distributor table
		@Override
		public List<Distributor> fetchDistributors() {
			log.debug("fetchDistributor DAO");
			// @formatter: off
				String sql = ""
				+ "SELECT * "
				+ "FROM distributors ";
			// @formatter: on
		
		return jdbcTemplate.query(sql, new RowMapper<>() {

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
		
		// add a new distributor
		@Override
		public Optional<Distributor> addNewDistributor(String distName, String website) {
			String sql = ""
					+ "INSERT INTO distributors (dist_name, website) "
					+ "VALUES (:dist_name, :website)";
			Map<String, Object> params = new HashMap<>();
			params.put("dist_name", distName);
			params.put("website", website);
			jdbcTemplate.update(sql,  params);
			
			return Optional.ofNullable(Distributor
					.builder()
					.dist_name(distName)
					.website(website)
					.build()
					);
		}
		
		// delete a distributor
		@Override
		public Optional<Distributor> deleteDistributor(int dist_pk){
			String sql = ""
					+ "DELETE FROM distributors "
					+ "WHERE dist_pk = :dist_pk";
			
			Map<String, Object> params = new HashMap<>();
			params.put("dist_pk", dist_pk);
			jdbcTemplate.update(sql, params);
			
			return Optional.ofNullable(Distributor
					.builder()
					.dist_pk(dist_pk)
					.build());
		}
}

package com.cmrwebstudio.beer.dao;

import java.util.Optional;

import com.cmrwebstudio.beer.entity.Distributor;

public interface PostDistributorDao {


	Distributor saveDistributor(String distName, String website);

	Optional<Distributor> fetchDistributor(String dist_name);

		
}

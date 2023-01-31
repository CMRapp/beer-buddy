package com.cmrwebstudio.beer.service;

import org.springframework.stereotype.Service;

import com.cmrwebstudio.beer.entity.Distributor;
import com.cmrwebstudio.beer.entity.DistributorPostRequest;

@Service
public interface PostDistributorService {

	Distributor createDistributor(DistributorPostRequest distributorPostRequest);

}

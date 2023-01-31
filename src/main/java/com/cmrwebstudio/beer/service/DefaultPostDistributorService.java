package com.cmrwebstudio.beer.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmrwebstudio.beer.dao.PostDistributorDao;
import com.cmrwebstudio.beer.entity.Distributor;
import com.cmrwebstudio.beer.entity.DistributorPostRequest;

@Service
public class DefaultPostDistributorService implements PostDistributorService {

	@Autowired
	private PostDistributorDao postDistributorDao;

	@Transactional
	@Override
	public Distributor createDistributor(DistributorPostRequest distributorPostRequest) {
		
		String distName = getDistributor(distributorPostRequest).getDist_name();
		String website = getDistributor(distributorPostRequest).getWebsite();
		return postDistributorDao.saveDistributor(distName, website);
	}

	/**
	 * 
	 * @param reviewRequest
	 * @return
	 */
	protected Distributor getDistributor(DistributorPostRequest distributorPostRequest) {
		return postDistributorDao
				.fetchDistributor(distributorPostRequest.getDist_name())
				.orElseThrow(() -> new NoSuchElementException("Distributor with name = "
				+ distributorPostRequest.getDist_name()+ " was not found."));
	}

}

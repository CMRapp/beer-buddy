package com.cmrwebstudio.beer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cmrwebstudio.beer.entity.Distributor;

/** The DistributorController interfaces with the DAO (Data Access Object) layers for all Distributor methods.
 *  
 *  The RequestMapping annotation is used to inform Spring the following data will be mapped
 *  to the URI listed
 *  @author cmrapp *
 */
@RequestMapping("/distributors")

public interface DistributorController {

	@GetMapping("/allDistributors")
	@ResponseStatus(code = HttpStatus.OK)
	List<Distributor> fetchDistributor();
	
	@PostMapping("/addDistributor")
	@ResponseStatus(code = HttpStatus.CREATED)
	Optional<Distributor> addNewDistributor(
			@RequestParam(required = true) String dist_name,
			@RequestParam(required = true) String website);
	
	@PostMapping("/updateDistributor")
	@ResponseStatus(code = HttpStatus.CREATED)
	Optional<Distributor> updateDistributor(
			@RequestParam(required = true) int dist_pk,
			@RequestParam(required = true) String dist_name,
			@RequestParam(required = true) String website);
	
	@DeleteMapping("/deleteDistributor")
	@ResponseStatus(code= HttpStatus.CREATED)
	Optional<Distributor> deleteDistributor(
			@RequestParam(required = true) int dist_pk);
	
}

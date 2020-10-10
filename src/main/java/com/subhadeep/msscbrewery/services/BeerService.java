package com.subhadeep.msscbrewery.services;

import com.subhadeep.msscbrewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveBeer(BeerDTO beerDto);

    BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteBeerbyId(UUID beerId);
}


package com.subhadeep.msscbrewery.services;

import com.subhadeep.msscbrewery.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImpl implements BeerService{
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerName("Pochabeer")
                .beerStyle("Desi")
                .build();
    }

    @Override
    public BeerDTO saveBeer(BeerDTO beerDto) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO) {
        //todo: implement it later
        return null;
    }

    @Override
    public void deleteBeerbyId(UUID beerId) {
        log.debug("deleting beer");
    }
}

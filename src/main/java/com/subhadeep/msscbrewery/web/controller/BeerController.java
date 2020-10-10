package com.subhadeep.msscbrewery.web.controller;

import com.subhadeep.msscbrewery.services.BeerService;
import com.subhadeep.msscbrewery.web.model.BeerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.memory.HeapBlock;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId)
    {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }


    @PostMapping   //create new beer
    public ResponseEntity saveBeer(@RequestBody BeerDTO beerDto)
    {
        BeerDTO savedBeer=beerService.saveBeer(beerDto);
        HttpHeaders headers=new HttpHeaders();
       //todo: add hostname to url
        headers.add("location","/api/v1/beer/" + savedBeer.getId().toString());
        return new ResponseEntity(headers,HttpStatus.ACCEPTED);
    }

    @PutMapping({"/{beerId}"}) //update beer
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO)
    {
        BeerDTO updatedBeer=beerService.updateBeer(beerId,beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerbyId(UUID beerId)
    {
       beerService.deleteBeerbyId(beerId);
    }
}


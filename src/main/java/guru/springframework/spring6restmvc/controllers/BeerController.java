package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.exceptions.NotFoundException;
import guru.springframework.spring6restmvc.models.beers.BeerDTO;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerController {

    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

    private final BeerService beerService;

    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity patchBeerById(@PathVariable UUID beerId, @RequestBody BeerDTO beer) {
        log.debug("Patch Beer by Id - in controller");

        if (beerService.patchBeerById(beerId, beer).isEmpty()) {
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity deleteBeerById(@PathVariable UUID beerId) {
        log.debug("Delete Beer by Id - in controller");

        if (!beerService.deleteBeerById(beerId)) {
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity updateBeerById(@PathVariable UUID beerId, @RequestBody BeerDTO beer) {
        log.debug("Update Beer by Id - in controller");

        if (beerService.updateBeerById(beerId, beer).isEmpty()) {
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(BEER_PATH)
    public ResponseEntity<BeerDTO> insertBeer(@Validated @RequestBody BeerDTO beer) {
        log.debug("Insert Beer - in controller");
        BeerDTO savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location",  BEER_PATH + "/" + savedBeer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping(BEER_PATH)
    public List<BeerDTO> getAllBeers() {
        log.debug("Get Beer List - in controller");
        return beerService.listAllBeers();
    }

    @GetMapping(BEER_PATH_ID)
    public BeerDTO getBeerById(@PathVariable UUID beerId) {
        log.debug("Get Beer by Id - in controller");
        return beerService.getBeerById(beerId).orElseThrow(NotFoundException::new);
    }
}

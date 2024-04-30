package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.models.beers.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    Optional<BeerDTO>  getBeerById(UUID id);

    List<BeerDTO> listAllBeers();

    BeerDTO saveNewBeer(BeerDTO beer);

    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

    void deleteBeerById(UUID beerId);

    void patchBeerById(UUID beerId, BeerDTO beer);
}

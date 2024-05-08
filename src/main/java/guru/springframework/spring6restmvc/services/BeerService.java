package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.models.beers.BeerDTO;
import guru.springframework.spring6restmvc.models.beers.BeerStyle;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    Optional<BeerDTO>  getBeerById(UUID id);

    Page<BeerDTO> listAllBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber,
                               Integer pageSize);

    BeerDTO saveNewBeer(BeerDTO beer);

    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

    Boolean deleteBeerById(UUID beerId);

    Optional<BeerDTO> patchBeerById(UUID beerId, BeerDTO beer);
}

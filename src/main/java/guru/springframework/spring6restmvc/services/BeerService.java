package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.models.beers.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID id);

    List<Beer> listAllBeers();
}

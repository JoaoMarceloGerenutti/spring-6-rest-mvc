package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.models.Beer;

import java.util.UUID;

public interface BeerService {

    Beer getBerrById(UUID id);
}

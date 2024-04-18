package guru.springframework.spring6restmvc.services.impl;

import guru.springframework.spring6restmvc.entities.BeerEntity;
import guru.springframework.spring6restmvc.mappers.BeerMapper;
import guru.springframework.spring6restmvc.models.beers.BeerDTO;
import guru.springframework.spring6restmvc.repositories.BeerRepository;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceJPA implements BeerService {

    private final BeerRepository beerRepository;

    private final BeerMapper beerMapper;

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        return Optional.ofNullable(beerMapper.beerEntityToBeerDto(beerRepository.findById(id)
                .orElse(null)));
    }

    @Override
    public List<BeerDTO> listAllBeers() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::beerEntityToBeerDto)
                .collect(Collectors.toList());
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {
        return beerMapper.beerEntityToBeerDto(beerRepository.save(beerMapper.beerDtoToBeerEntity(beer)));
    }

    @Override
    public void updateBeerById(UUID beerId, BeerDTO beer) {

    }

    @Override
    public void deleteBeerById(UUID beerId) {

    }

    @Override
    public void patchBeerById(UUID beerId, BeerDTO beer) {

    }
}

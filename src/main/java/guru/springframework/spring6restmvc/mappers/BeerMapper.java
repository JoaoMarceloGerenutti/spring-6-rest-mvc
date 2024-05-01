package guru.springframework.spring6restmvc.mappers;

import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.models.beers.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeerEntity(BeerDTO beerDTO);

    BeerDTO beerEntityToBeerDto(Beer beer);
}

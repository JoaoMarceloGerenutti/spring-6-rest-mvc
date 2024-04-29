package guru.springframework.spring6restmvc.mappers;

import guru.springframework.spring6restmvc.entities.BeerEntity;
import guru.springframework.spring6restmvc.models.beers.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerEntity beerDtoToBeerEntity(BeerDTO beerDTO);

    BeerDTO beerEntityToBeerDto(BeerEntity beerEntity);
}

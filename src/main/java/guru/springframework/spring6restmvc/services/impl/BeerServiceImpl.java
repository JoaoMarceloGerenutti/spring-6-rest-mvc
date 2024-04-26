package guru.springframework.spring6restmvc.services.impl;

import guru.springframework.spring6restmvc.models.beers.Beer;
import guru.springframework.spring6restmvc.models.beers.BeerStyle;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private final Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {

        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("123456")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyle.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        this.beerMap = new HashMap<>();
        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public List<Beer> listAllBeers(){
        log.debug("Get Beer List - in service.");
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer saveNewBeer(Beer beer) {
        log.debug("Saving new Beer - in service.");

        Beer savedBeer = Beer.builder()
                .id(UUID.randomUUID())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .version(beer.getVersion())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .quantityOnHand(beer.getQuantityOnHand())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(savedBeer.getId(), savedBeer);
        return savedBeer;
    }

    @Override
    public void updateBeerById(UUID beerId, Beer beer) {
        log.debug("Updating Beer by Id - in service. Id: " + beerId.toString());

        Beer existing = beerMap.get(beerId);
        existing.setBeerName(beer.getBeerName());
        existing.setBeerStyle(beer.getBeerStyle());
        existing.setVersion(beer.getVersion());
        existing.setUpc(beer.getUpc());
        existing.setPrice(beer.getPrice());
        existing.setQuantityOnHand(beer.getQuantityOnHand());
        existing.setUpdateDate(LocalDateTime.now());

        beerMap.put(existing.getId(), existing);
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting Beer by Id - in service. Id: " + beerId.toString());
        beerMap.remove(beerId);
    }

    @Override
    public void patchBeerById(UUID beerId, Beer beer) {
        log.debug("Patch Beer by Id - in service. Id: " + beerId.toString());
        Beer existing = beerMap.get(beerId);

        if (StringUtils.hasText(beer.getBeerName())) {
            existing.setBeerName(beer.getBeerName());
        }

        if (beer.getBeerStyle() != null) {
            existing.setBeerStyle(beer.getBeerStyle());
        }

        if (beer.getVersion() != null) {
            existing.setVersion(beer.getVersion());
        }

        if (StringUtils.hasText(beer.getUpc())) {
            existing.setUpc(beer.getUpc());
        }

        if (beer.getPrice() != null) {
            existing.setPrice(beer.getPrice());
        }

        if (beer.getQuantityOnHand() != null) {
            existing.setQuantityOnHand(beer.getQuantityOnHand());
        }

        existing.setUpdateDate(LocalDateTime.now());
    }

    @Override
    public Beer getBeerById(UUID uuid) {
        log.debug("Get Beer by Id - in service. Id: " + uuid.toString());
        return beerMap.get(uuid);
    }
}

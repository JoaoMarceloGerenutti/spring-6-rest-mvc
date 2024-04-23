package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.BeerEntity;
import guru.springframework.spring6restmvc.models.beers.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeer() {
        BeerEntity savedBeer = beerRepository.save(BeerEntity.builder()
                        .beerName("New Beer")
                        .beerStyle(BeerStyle.PALE_ALE)
                        .upc("21311241")
                        .price(new BigDecimal("11.99"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }

}
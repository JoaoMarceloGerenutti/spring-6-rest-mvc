package guru.springframework.spring6restmvc.bootstrap;

import guru.springframework.spring6restmvc.entities.BeerEntity;
import guru.springframework.spring6restmvc.entities.CustomerEntity;
import guru.springframework.spring6restmvc.models.beers.BeerStyle;
import guru.springframework.spring6restmvc.repositories.BeerRepository;
import guru.springframework.spring6restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData() {

        if (beerRepository.count() == 0) {
            BeerEntity beer1 = BeerEntity.builder()
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

            BeerEntity beer2 = BeerEntity.builder()
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

            BeerEntity beer3 = BeerEntity.builder()
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

            beerRepository.saveAll(Arrays.asList(beer1, beer2, beer3));
        }
    }

    private void loadCustomerData() {

        if (customerRepository.count() == 0) {
            CustomerEntity customer1 = CustomerEntity.builder()
                    .id(UUID.randomUUID())
                    .name("Joao Marcelo")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            CustomerEntity customer2 = CustomerEntity.builder()
                    .id(UUID.randomUUID())
                    .name("Julia Cortizo")
                    .version(2)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            CustomerEntity customer3 = CustomerEntity.builder()
                    .id(UUID.randomUUID())
                    .name("Sandra Regina")
                    .version(3)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        }
    }
}

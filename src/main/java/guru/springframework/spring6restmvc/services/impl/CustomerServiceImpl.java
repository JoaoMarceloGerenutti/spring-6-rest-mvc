package guru.springframework.spring6restmvc.services.impl;

import guru.springframework.spring6restmvc.models.customers.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Joao Marcelo")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Julia Cortizo")
                .version(2)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Sandra Regina")
                .version(3)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        this.customerMap = new HashMap<>();
        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public Customer getCustomerById(UUID uuid) {
        log.debug("Get Customer by Id - in service. Id: " + uuid.toString());
        return customerMap.get(uuid);
    }

    @Override
    public List<Customer> listAllCustomers() {
        log.debug("Get Customer List - in service.");
        return new ArrayList<>(customerMap.values());
    }
}

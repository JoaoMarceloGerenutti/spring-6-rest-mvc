package guru.springframework.spring6restmvc.services.impl;

import guru.springframework.spring6restmvc.models.customers.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public Customer saveNewCustomer(Customer customer) {
        log.debug("Saving new Customer - in service.");

        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .name(customer.getName())
                .version(customer.getVersion())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);
        return savedCustomer;
    }

    @Override
    public void updateCustomerById(UUID customerId, Customer customer) {
        log.debug("Updating Customer by Id - in service. Id: " + customerId.toString());

        Customer existing = customerMap.get(customerId);
        existing.setName(customer.getName());
        existing.setVersion(customer.getVersion());
        existing.setUpdateDate(LocalDateTime.now());

        customerMap.put(existing.getId(), existing);
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("Deleting Customer by Id - in service. Id: " + customerId.toString());
        customerMap.remove(customerId);
    }

    @Override
    public void patchCustomerById(UUID customerId, Customer customer) {
        log.debug("Patch Customer by Id - in service. Id: " + customerId.toString());
        Customer existing = customerMap.get(customerId);

        if (StringUtils.hasText(customer.getName())) {
            existing.setName(customer.getName());
        }

        if (customer.getVersion() != null) {
            existing.setVersion(customer.getVersion());
        }

        existing.setUpdateDate(LocalDateTime.now());
    }
}

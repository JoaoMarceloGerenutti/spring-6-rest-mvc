package guru.springframework.spring6restmvc.services.impl;

import guru.springframework.spring6restmvc.mappers.CustomerMapper;
import guru.springframework.spring6restmvc.models.customers.CustomerDTO;
import guru.springframework.spring6restmvc.repositories.CustomerRepository;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.ofNullable(customerMapper.customerEntityToCustomerDto(customerRepository.findById(id)
                .orElse(null)));
    }

    @Override
    public List<CustomerDTO> listAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerEntityToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return customerMapper.customerEntityToCustomerDto(customerRepository
                .save(customerMapper.customerDtoToCustomerEntity(customer)));
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customer) {
        customerRepository.findById(customerId).ifPresent(foundCustomer -> {
            foundCustomer.setName(customer.getName());
            foundCustomer.setUpdateDate(LocalDateTime.now());
            customerRepository.save(foundCustomer);
        });
    }

    @Override
    public void deleteCustomerById(UUID customerId) {

    }

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO customer) {

    }
}

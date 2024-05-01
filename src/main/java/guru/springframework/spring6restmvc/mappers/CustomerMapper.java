package guru.springframework.spring6restmvc.mappers;

import guru.springframework.spring6restmvc.entities.Customer;
import guru.springframework.spring6restmvc.models.customers.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomerEntity(CustomerDTO customerDTO);

    CustomerDTO customerEntityToCustomerDto(Customer customer);
}

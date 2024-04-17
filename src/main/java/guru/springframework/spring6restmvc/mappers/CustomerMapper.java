package guru.springframework.spring6restmvc.mappers;

import guru.springframework.spring6restmvc.entities.CustomerEntity;
import guru.springframework.spring6restmvc.models.customers.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerEntity customerEntityDtoToCustomer(CustomerDTO customerDTO);

    CustomerDTO customerEntityToCustomerDto(CustomerEntity customerEntity);
}

package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
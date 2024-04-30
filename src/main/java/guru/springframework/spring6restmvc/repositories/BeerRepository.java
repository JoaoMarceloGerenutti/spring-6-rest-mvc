package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.BeerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<BeerEntity, UUID> {
}
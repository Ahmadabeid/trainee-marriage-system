package traineemarriagesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import traineemarriagesystem.model.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}

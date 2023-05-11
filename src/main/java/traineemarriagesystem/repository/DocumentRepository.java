package traineemarriagesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import traineemarriagesystem.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}

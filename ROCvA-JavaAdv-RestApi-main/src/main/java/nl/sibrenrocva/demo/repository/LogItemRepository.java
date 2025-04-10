package nl.sibrenrocva.demo.repository;

import nl.sibrenrocva.demo.model.LogItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogItemRepository extends JpaRepository<LogItem, Long> {
    // Geen extra methods nodig voor nu
}

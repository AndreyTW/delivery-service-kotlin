package ru.andreyTw.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andreyTw.delivery.db.ClientTypeData;

@Repository
public interface ClientTypeDataRepository extends JpaRepository<ClientTypeData, Long> {
}

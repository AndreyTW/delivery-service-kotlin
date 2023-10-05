package ru.andreyTw.delivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andreyTw.delivery.db.ClientTypeData;

@Repository
public interface ClientTypeDataRepository extends CrudRepository<ClientTypeData, Long> {
}

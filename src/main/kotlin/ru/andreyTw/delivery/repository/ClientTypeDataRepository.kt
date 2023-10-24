package ru.andreyTw.delivery.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.andreyTw.delivery.db.ClientTypeData

@Repository
interface ClientTypeDataRepository : CrudRepository<ClientTypeData?, Long?> {
    fun findByName(name: String?): ClientTypeData?
}

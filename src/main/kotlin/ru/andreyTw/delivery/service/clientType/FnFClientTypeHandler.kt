package ru.andreyTw.delivery.service.clientType

import org.springframework.stereotype.Service
import ru.andreyTw.delivery.ClientType
import ru.andreyTw.delivery.repository.ClientTypeDataRepository

@Service
class FnFClientTypeHandler(private val clientTypeDataRepository: ClientTypeDataRepository) : ClientTypeHandler {

    override fun calculate(cartAmount: Int): Int {
        val fnfClientTypeData = clientTypeDataRepository.findByName(type.name)

        return (cartAmount * (1 - fnfClientTypeData?.discountValue!! / 100.0)).toInt()
    }

    override val type: ClientType = ClientType.FnF
}

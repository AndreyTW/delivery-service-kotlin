package ru.andreyTw.delivery.service.clientType

import org.springframework.stereotype.Service
import ru.andreyTw.delivery.ClientType
import ru.andreyTw.delivery.repository.ClientTypeDataRepository

@Service
class CommonClientTypeHandler(private val clientTypeDataRepository: ClientTypeDataRepository) : ClientTypeHandler {

    override fun calculate(cartAmount: Int): Int {
        val commonClientTypeData = clientTypeDataRepository.findByName(type.name)

        return if (cartAmount >= commonClientTypeData.limitValue) {
            cartAmount
        } else {
            cartAmount + commonClientTypeData.deliveryCost
        }
    }

    override val type: ClientType = ClientType.COMMON
}
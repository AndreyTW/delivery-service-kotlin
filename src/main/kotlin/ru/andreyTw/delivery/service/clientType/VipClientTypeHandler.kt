package ru.andreyTw.delivery.service.clientType

import org.springframework.stereotype.Service
import ru.andreyTw.delivery.ClientType
import ru.andreyTw.delivery.repository.ClientTypeDataRepository

@Service
class VipClientTypeHandler(private val clientTypeDataRepository: ClientTypeDataRepository) : ClientTypeHandler {

    override fun calculate(cartAmount: Int): Int {
        val vipClientTypeData = clientTypeDataRepository.findByName(type.name)

        return when {
            cartAmount >= vipClientTypeData?.limitValue!! ->
                (cartAmount * (1 - vipClientTypeData.discountValue!! / 100.0)).toInt()

            else -> cartAmount
        }
    }

    override val type: ClientType = ClientType.VIP
}

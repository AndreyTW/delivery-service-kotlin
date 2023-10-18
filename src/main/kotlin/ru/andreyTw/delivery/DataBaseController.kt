package ru.andreyTw.delivery

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.andreyTw.delivery.db.ClientTypeData
import ru.andreyTw.delivery.repository.ClientTypeDataRepository

@RestController
class DataBaseController(
    private val clientTypeDataRepository: ClientTypeDataRepository
) {

    @GetMapping("/addClientType/{name}/{deliveryCost}/{discountValue}/{limitValue}")
    fun addClientType(
        @PathVariable("name") name: String,
        @PathVariable("deliveryCost") deliveryCost: Int,
        @PathVariable("discountValue") discountValue: Int,
        @PathVariable("limitValue") limitValue: Int
    ): String {
        val commonTypeData = ClientTypeData()
        commonTypeData.name = name
        commonTypeData.deliveryCost = deliveryCost
        commonTypeData.discountValue = discountValue
        commonTypeData.limitValue = limitValue

        clientTypeDataRepository.save(commonTypeData)

        return "Client type $name{" +
                "deliveryCost = $deliveryCost, " +
                "discountValue = $discountValue, " +
                "limitValue = $limitValue} " +
                "was saved to DB!"
    }

    @GetMapping("/findAll")
    fun findAllClientTypes(): String {
        return clientTypeDataRepository.findAll().toString()
    }

    @GetMapping("/findByName/{name}")
    fun findClientTypeByName(
        @PathVariable("name") name: String
    ): String {
        return clientTypeDataRepository.findByName(name).toString()
    }
}
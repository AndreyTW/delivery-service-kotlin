package ru.andreyTw.delivery

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.andreyTw.delivery.db.ClientTypeData
import ru.andreyTw.delivery.service.ClientTypeDataService

@RestController
class DataBaseController(
    private val clientTypeDataService: ClientTypeDataService
) {

    @GetMapping("/testHandle")
    fun test(): String {
        val commonTypeData = ClientTypeData()
        commonTypeData.clientTypeName = "COMMON"
        commonTypeData.deliveryCost = 250
        commonTypeData.discountValue = 0
        commonTypeData.limitValue = 1000

        clientTypeDataService.save(commonTypeData)

        return "Entity was saved to DB!"
    }
}
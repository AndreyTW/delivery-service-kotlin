package ru.andreyTw.delivery

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.eq
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import ru.andreyTw.delivery.repository.ClientTypeDataRepository
import ru.andreyTw.delivery.service.CostCalculationService
import ru.andreyTw.delivery.service.clientType.UnknownClientTypeException

@ExtendWith(MockitoExtension::class)
@WebMvcTest(controllers = [DeliveryController::class])
internal class DeliveryControllerShould {
    @MockBean
    private lateinit var clientTypeDataRepository: ClientTypeDataRepository

    @MockBean
    private lateinit var costCalculationServiceMock: CostCalculationService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    @Throws(Exception::class, UnknownClientTypeException::class)
    fun calculatePriceForVipAndAmountOf100() {

        val clientType = ClientType.VIP.title
        val cartAmount = 100

        val result = mockMvc.get("/delivery/$clientType/$cartAmount/")

        result.andExpect { status { isOk() } }
        verify(costCalculationServiceMock).calculate(eq(clientType), eq(cartAmount))
    }
}
package ru.andreyTw.delivery.service.clientType

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.eq
import ru.andreyTw.delivery.ClientType
import ru.andreyTw.delivery.db.ClientTypeData
import ru.andreyTw.delivery.repository.ClientTypeDataRepository

@ExtendWith(MockitoExtension::class)
class VipClientTypeHandlerShould {

    @Mock
    private lateinit var clientTypeDataRepositoryMock: ClientTypeDataRepository
    private lateinit var vipClientTypeHandler: VipClientTypeHandler

    @BeforeEach
    fun setUp() {
        val vipTypeData = ClientTypeData()
        vipTypeData.name = "VIP"
        vipTypeData.deliveryCost = 0
        vipTypeData.discountValue = 5
        vipTypeData.limitValue = 2500
        `when`(clientTypeDataRepositoryMock.findByName(eq("VIP"))).thenReturn(vipTypeData)

        vipClientTypeHandler = VipClientTypeHandler(clientTypeDataRepositoryMock)
    }

    @Test
    fun return_999_when_VIP_and_999_are_given() {
        assertEquals(999, vipClientTypeHandler.calculate(999))
    }

    @Test
    fun return_2499_when_VIP_and_2499_are_given() {
        assertEquals(2499, vipClientTypeHandler.calculate(2499))
    }

    @Test
    fun return_2500_when_VIP_and_2375_are_given() {
        assertEquals(2375, vipClientTypeHandler.calculate(2500))
    }

    //    @Test
    fun returnVipClientTypeWhenAsked() {
        assertEquals(ClientType.VIP, vipClientTypeHandler.type)
    }
}

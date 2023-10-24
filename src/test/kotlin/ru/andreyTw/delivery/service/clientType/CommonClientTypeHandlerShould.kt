package ru.andreyTw.delivery.service.clientType

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.eq
import ru.andreyTw.delivery.db.ClientTypeData
import ru.andreyTw.delivery.repository.ClientTypeDataRepository

@ExtendWith(MockitoExtension::class)
class CommonClientTypeHandlerShould {

    @Mock
    private lateinit var clientTypeDataRepositoryMock: ClientTypeDataRepository
    private lateinit var commonClientTypeHandler: CommonClientTypeHandler

    @BeforeEach
    fun setUp() {
        val commonTypeData = ClientTypeData()
        commonTypeData.name = "COMMON"
        commonTypeData.deliveryCost = 250
        commonTypeData.discountValue = 0
        commonTypeData.limitValue = 1000
        Mockito.`when`(clientTypeDataRepositoryMock.findByName(eq("COMMON"))).thenReturn(commonTypeData)

        commonClientTypeHandler = CommonClientTypeHandler(clientTypeDataRepositoryMock)
    }

    @Test
    fun return_1249_when_Obichny_and_999_are_given() {
        assertEquals(1249, commonClientTypeHandler.calculate(999))
    }

    @Test
    fun return_1000_when_Obichny_and_1000_are_given() {
        assertEquals(1000, commonClientTypeHandler.calculate(1000))
    }

//    @Test
//    fun returnCommonClientTypeWhenAsked() {
//        assertEquals(ClientType.COMMON, commonClientTypeHandler.type)
//    }
}

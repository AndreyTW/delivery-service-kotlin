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
class FnFClientTypeHandlerShould {

    @Mock
    private lateinit var clientTypeDataRepositoryMock: ClientTypeDataRepository
    private lateinit var fnFClientTypeHandler: FnFClientTypeHandler

    @BeforeEach
    fun setUp() {
        val fnfTypeData = ClientTypeData()
        fnfTypeData.name = "FnF"
        fnfTypeData.deliveryCost = 0
        fnfTypeData.discountValue = 2
        fnfTypeData.limitValue = 0
        Mockito.`when`(clientTypeDataRepositoryMock.findByName(eq("FnF"))).thenReturn(fnfTypeData)

        fnFClientTypeHandler = FnFClientTypeHandler(clientTypeDataRepositoryMock)
    }

    @Test
    fun return_980_when_FriendsAndFamily_and_1000_are_given() {
        assertEquals(980, fnFClientTypeHandler.calculate(1000))
    }

//    @Test
//    fun returnFnfClientTypeWhenAsked() {
//        assertEquals(ClientType.FnF, fnFClientTypeHandler.type)
//    }
}

package ru.andreyTw.delivery

import jakarta.annotation.PostConstruct
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.web.servlet.function.RequestPredicates
import org.springframework.web.servlet.function.RouterFunction
import org.springframework.web.servlet.function.RouterFunctions
import org.springframework.web.servlet.function.ServerResponse
import ru.andreyTw.delivery.db.ClientTypeData
import ru.andreyTw.delivery.repository.ClientTypeDataRepository
import ru.andreyTw.delivery.utils.logger

@SpringBootApplication
open class Application(private val clientTypeDataRepository: ClientTypeDataRepository) {

    private val log: Logger = logger<Application>()

    @Bean
    open fun htmlRouter(@Value("classpath:/static/index.html") html: Any): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.GET("/")) {
            ServerResponse.ok().contentType(
                MediaType.TEXT_HTML
            ).body(html)
        }
    }

    @PostConstruct
    fun initDb() {
        val commonTypeData = ClientTypeData()
        commonTypeData.name = "COMMON"
        commonTypeData.deliveryCost = 250
        commonTypeData.discountValue = 0
        commonTypeData.limitValue = 1000

        val vipTypeData = ClientTypeData()
        vipTypeData.name = "VIP"
        vipTypeData.deliveryCost = 0
        vipTypeData.discountValue = 5
        vipTypeData.limitValue = 2500

        val fnfTypeData = ClientTypeData()
        fnfTypeData.name = "FnF"
        fnfTypeData.deliveryCost = 0
        fnfTypeData.discountValue = 2
        fnfTypeData.limitValue = 0

        clientTypeDataRepository.save(commonTypeData)
        clientTypeDataRepository.save(vipTypeData)
        clientTypeDataRepository.save(fnfTypeData)

        log.info("DB was successfully initialized!")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}

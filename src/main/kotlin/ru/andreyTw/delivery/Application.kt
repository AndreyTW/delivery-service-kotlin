package ru.andreyTw.delivery

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.web.servlet.function.*

@SpringBootApplication
open class Application {
    @Bean
    open fun htmlRouter(@Value("classpath:/static/index.html") html: Any): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.GET("/")) {
            ServerResponse.ok().contentType(
                MediaType.TEXT_HTML
            ).body(html)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

//            val clientTypeDataService = ClientTypeDataService()

//            val commonTypeData = ClientTypeData()
//            commonTypeData.clientTypeName = "COMMON"
//            commonTypeData.deliveryCost = 250
//            commonTypeData.discountValue = 0
//            commonTypeData.limitValue = 1000
//            val commonTypeData = ClientTypeData().apply {
//                clientTypeName = "COMMON";
//                deliveryCost = 250;
//                discountValue = 0;
//                limitValue = 1000
//            }

            SpringApplication.run(Application::class.java, *args)
        }
    }
}

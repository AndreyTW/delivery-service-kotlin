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
            SpringApplication.run(Application::class.java, *args)
        }
    }
}

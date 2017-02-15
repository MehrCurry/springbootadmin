package springbootadmin

import com.hazelcast.config.Config
import de.codecentric.boot.admin.config.EnableAdminServer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
open class SpringBootAdminApplication {

    @Bean
    open fun config(): Config {
        return Config()
    }

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(SpringBootAdminApplication::class.java, *args)
        }
    }
}

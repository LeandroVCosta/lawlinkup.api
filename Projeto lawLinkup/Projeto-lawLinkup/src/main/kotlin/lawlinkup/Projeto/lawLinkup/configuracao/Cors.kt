package lawlinkup.Projeto.lawLinkup.configuracao

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Configuration
class Cors {

        @Override
        fun addCorsMappings(registro: CorsRegistry) {
            registro.addMapping("/**").allowedOrigins("http://localhost:3000/")
                .allowedMethods("GET", "POST","PATCH", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
                .allowedOrigins("*")
                .allowedHeaders("content-type", "hash")
                .exposedHeaders("content-type", "hash");
        }
}
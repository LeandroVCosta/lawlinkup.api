package lawlinkup.Projeto.lawLinkup.infra.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
@Configuration
@EnableWebSecurity
class SecurityConfiguration {

//    @Override
    @Throws(java.lang.Exception::class)
    @Bean
        fun SecurityFilterChain(http: HttpSecurity): SecurityFilterChain{
       return http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
//                .cors().disable()
                .authorizeHttpRequests()
                .requestMatchers("/cliente/**", "/login/**", "/advogados/**", "/docs/**", "/swagger-ui.html/**","/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui/index.html/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .build()
        }
    }


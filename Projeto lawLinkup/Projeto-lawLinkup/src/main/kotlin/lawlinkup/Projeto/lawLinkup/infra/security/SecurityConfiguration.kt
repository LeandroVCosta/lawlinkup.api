//package lawlinkup.Projeto.lawLinkup.infra.security
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.http.SessionCreationPolicy
//
//@Configuration
//class SecurityConfiguration {
//
//    @Override
//    // outras configurações
//    // outras configurações
//    fun configure(http: HttpSecurity) : Exception{
//       return    http.csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and().authorizeRequests()
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // permite acesso a recursos estáticos
//                .antMatchers("/public/**").permitAll() // permite acesso sem autenticação a URLs que começam com "/public/"
//                .anyRequest().authenticated() // exige autenticação para todas as outras URLs
//            // outras configurações
//        }
//    }

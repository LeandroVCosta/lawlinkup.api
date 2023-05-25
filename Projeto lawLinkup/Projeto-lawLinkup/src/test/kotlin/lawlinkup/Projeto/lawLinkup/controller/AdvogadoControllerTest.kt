package lawlinkup.Projeto.lawLinkup.controller

import jakarta.persistence.Entity
import lawlinkup.Projeto.lawLinkup.ProjetoLawLinkupApplication
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

class AdvogadoControllerTest {
    @Test
    fun `classe deve estar anotada com @RestController`() {
        val classe = AdvogadoController::class.java
        assertTrue(
                classe.isAnnotationPresent(RestController::class.java))
    }

    @Test
    fun `classe deve estar anotada com @RequestMapping`() {
        val classe = AdvogadoController::class.java

        assertTrue(
                classe.isAnnotationPresent(RequestMapping::class.java)
        )
    }
}
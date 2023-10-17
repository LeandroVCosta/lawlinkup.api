package lawlinkup.dto.responses

import lawlinkup.domain.users.Advogado

data class advogadoAvaliacaoResponse(
        val advogado: Advogado,
        val mediaAvaliacao: Double
)

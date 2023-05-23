package lawlinkup.Projeto.lawLinkup.autenticacao

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.advogado.Advogado
import lawlinkup.Projeto.lawLinkup.cliente.Cliente
import lawlinkup.Projeto.lawLinkup.cliente.DadosCadastroClienteDto
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component


//@Table(name = "Usuario" )
@Entity(name = "Usuario")
class Usuario(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var email:String,
    var senha:String,
    var ativo:Boolean

) : UserDetails {

    override fun getAuthorities(): Collection<out GrantedAuthority>  {
        return  listOf(SimpleGrantedAuthority("ROLE_USER"))
    }


    override fun getPassword(): String {
    return senha
    }

    override fun getUsername(): String {
    return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true

    }

    override fun isEnabled(): Boolean {
        return ativo;
    }
    fun deslogarUsuario(){
        this.ativo = false
    }
    fun logarUsuario(){
        this.ativo = true
    }

}



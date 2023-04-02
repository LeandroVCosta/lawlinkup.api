package lawlinkup.Projeto.lawLinkup.autenticacao

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Table(name = "cliente")
@Entity(name = "Usuario")
class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var login:String,
    var senha:String

) : UserDetails {

    override fun getAuthorities(): Collection<out GrantedAuthority>  {
        return  listOf(SimpleGrantedAuthority("ROLE_USER"))
    }


    override fun getPassword(): String {
    return senha
    }

    override fun getUsername(): String {
    return login
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
        return true
    }

}



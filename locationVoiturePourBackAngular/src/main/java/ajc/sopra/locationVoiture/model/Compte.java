package ajc.sopra.locationVoiture.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "compte")
public class Compte implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Email
	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	@OneToOne(mappedBy = "compte")
	private Personne personne;
	
	public Compte() {

	}
	
	public Compte(@NotBlank @Email String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	

	public Compte(@NotBlank @Email String email, String password, Personne personne) {
		this.email = email;
		this.password = password;
		this.personne = personne;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = null;
		if(personne instanceof Admin) {
			role="ROLE_ADMIN";
		}else if(personne instanceof Client) {
			role="ROLE_CLIENT";
		}else if(personne instanceof Loueur) {
			role="ROLE_LOUEUR";
		}
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}

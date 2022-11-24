package ajc.sopra.locationVoiture.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "compte")
public class Compte implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	private Long id;
	@NotBlank
	@Email
	@Column(name = "email", length = 255, nullable = false, unique = true)
	@JsonView(JsonViews.Common.class)
	private String email;
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	@JsonView(JsonViews.Common.class)
	@Column(length = 35,nullable = false)
	protected String nom;
	
	@JsonView(JsonViews.Common.class)
	@Column(length = 35,nullable = false)
	protected String prenom;
	
	@JsonView(JsonViews.Common.class)
	@Column(length = 35)
	protected Adresse adresse;

	
	public Compte() {

	}
	

	public Compte(Long id, @NotBlank @Email String email, String password, String nom, String prenom, Adresse adresse
			) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		
	}

	public Compte(@NotBlank @Email String email, String password, String nom, String prenom, Adresse adresse
			) {
		super();
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		
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
	
	

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
		
		
		
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_"+getClass().getSimpleName()));
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

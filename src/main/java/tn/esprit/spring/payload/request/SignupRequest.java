package tn.esprit.spring.payload.request;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.spring.Entity.ImageVideo;

@Getter
@Setter
public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;

  private long telephone;
  
//@JsonIgnore
		@OneToMany(mappedBy="user",cascade =CascadeType.REMOVE)
		@JsonIgnoreProperties("user")
		private Set<ImageVideo> imageVideo ;
  
  
  public long getTelephone() {
	return telephone;
}

public void setTelephone(long telephone) {
	this.telephone = telephone;
}

@NotBlank
  @Size(min = 6, max = 40)
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }
}

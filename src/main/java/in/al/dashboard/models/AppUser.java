package in.al.dashboard.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

/**
 * The User model
 * @author rockyj
 */
@Component
@Entity
public class AppUser implements Serializable {
  
  /**
   * User Role
   */
  public enum Role {

    User(),
    Admin();

    /**
     * Check role
     * @param other
     * @return 
     */
    public boolean greaterEqual(Role other) {
      return compareTo(other) >= 0;
    }
  }
  
  @Id
  @GeneratedValue
  private Long id;
  
  @Version
  protected int version;
  
  @NotNull
  private String name;
  
  @NotNull
  private String email;
  
  @NotNull
  private String password;
  
  @NotNull
  private Role userRole;
  
  @NotNull
  private String token;
  
  @NotNull
  private Boolean active;
  
  @NotNull
  private Boolean tokenActive;
  
  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private Date createdOn;
  
  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private Date tokenGeneratedOn;
  
  public Long getId() {
    return id;
  }

  public int getVersion() {
    return version;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getToken() {
    return token;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Boolean getTokenActive() {
    return tokenActive;
  }

  public void setTokenActive(Boolean tokenActive) {
    this.tokenActive = tokenActive;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public Date getTokenGeneratedOn() {
    return tokenGeneratedOn;
  }

  public void setTokenGeneratedOn(Date tokenGeneratedOn) {
    this.tokenGeneratedOn = tokenGeneratedOn;
  }

  public Role getUserRole() {
    return userRole;
  }

  public void setUserRole(Role userRole) {
    this.userRole = userRole;
  }
  
  /**
   * Check role
   */
  public boolean hasRole(Role desiredRole) {
    return userRole.greaterEqual(desiredRole);
  }
  
  /**
   * Generate a hashed password
   * @param plainPassword 
   */
  public void setPassword(String plainPassword){
    this.password = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
  }
  
  /**
   * Generates a random token
   */
  public void setToken() {
    this.token = UUID.randomUUID().toString();
  }
  
}

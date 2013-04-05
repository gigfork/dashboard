package in.al.dashboard.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import org.springframework.stereotype.Component;

/**
 * A Sample data class
 * @author rockyj
 */
@Component
@Entity
public class SampleData implements Serializable {
  
  @Id
  @GeneratedValue
  private Long id;
  
  @Version
  protected int version;
  
  private Long someValue;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getVersion() {
    return version;
  }

  public Long getSomeValue() {
    return someValue;
  }

  public void setSomeValue(Long someValue) {
    this.someValue = someValue;
  }
  
}

package in.al.dashboard.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 * Sales Data
 * @author rockyj
 */
@Component
@Entity
public class SalesData implements Serializable {
  
  @Id
  @GeneratedValue
  private Long id;
  
  @Version
  protected int version;
  
  @NotNull
  private Integer yearOfSale;
  
  @NotNull
  private String monthOfSale;
  
  @NotNull
  private Long unitsOfSale;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getVersion() {
    return version;
  }

  public Integer getYearOfSale() {
    return yearOfSale;
  }

  public void setYearOfSale(Integer yearOfSale) {
    this.yearOfSale = yearOfSale;
  }

  public String getMonthOfSale() {
    return monthOfSale;
  }

  public void setMonthOfSale(String monthOfSale) {
    this.monthOfSale = monthOfSale;
  }

  public Long getUnitsOfSale() {
    return unitsOfSale;
  }

  public void setUnitsOfSale(Long unitsOfSale) {
    this.unitsOfSale = unitsOfSale;
  }
  
}

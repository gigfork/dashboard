package in.al.dashboard.repos;

import in.al.dashboard.models.SalesData;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository for sample data
 *
 * @author rockyj
 */
@Repository
@Transactional
public class SalesDataRepository {
  
  private static final Log LOG = LogFactory.getLog(SalesDataRepository.class);

  @PersistenceContext
  private EntityManager em;

  /**
   * Save SalesData
   */
  public void saveData(SalesData data) {
    em.persist(data);
    em.flush();
  }

  /**
   * Get sales data
   */
  public List getSalesData() {
    List data = em.createQuery("select sum(unitsOfSale), monthOfSale, yearOfSale from SalesData group by yearOfSale, monthOfSale").getResultList();
    
//    CriteriaBuilder cb = em.getCriteriaBuilder();
//    CriteriaQuery<SalesData> cq = cb.createQuery(SalesData.class);
//
//    Root<SalesData> c = cq.from(SalesData.class);
//    cq.select(c, cb.sum(c.get("")));
//    cq.groupBy(c.get("monthOfSale"));
//    cq.groupBy(c.get("yearOfSale"));
//    
//    TypedQuery<SalesData> q = em.createQuery(cq);
//    List<SalesData> data = q.getResultList();
    
    return data;
  }
}

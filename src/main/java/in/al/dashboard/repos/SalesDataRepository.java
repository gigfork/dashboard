package in.al.dashboard.repos;

import in.al.dashboard.models.SalesData;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
  public List<SalesData> getData() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<SalesData> cq = cb.createQuery(SalesData.class);
    Root<SalesData> pet = cq.from(SalesData.class);
    cq.select(pet);
    TypedQuery<SalesData> q = em.createQuery(cq);
    List<SalesData> data = q.getResultList();
    return data;
  }
}

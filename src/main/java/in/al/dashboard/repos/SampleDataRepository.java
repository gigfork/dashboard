package in.al.dashboard.repos;

import in.al.dashboard.models.SampleData;
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
public class SampleDataRepository {

  @PersistenceContext
  private EntityManager em;

  /**
   * Save SampleData
   */
  public void saveData(SampleData data) {
    em.persist(data);
    em.flush();
  }

  /**
   * Get sales data
   */
  public List<SampleData> getData() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<SampleData> cq = cb.createQuery(SampleData.class);
    
    Root<SampleData> sampleData = cq.from(SampleData.class);
    cq.select(sampleData);
    
    TypedQuery<SampleData> q = em.createQuery(cq);
    List<SampleData> data = q.getResultList();
    
    return data;
  }
}

package in.al.dashboard.repos;

import in.al.dashboard.models.SampleData;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository for sample data
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
  public void savePost(SampleData data) {
    em.persist(data);
    em.flush();
  }
  
}

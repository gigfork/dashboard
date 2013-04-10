package in.al.dashboard.repos;

import in.al.dashboard.models.AppUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * User Repo
 * @author rockyj
 */
@Repository
@Transactional
public class UserRepository {
  
  private static final Log LOG = LogFactory.getLog(SalesDataRepository.class);
  @PersistenceContext
  private EntityManager em;

  /**
   * Save SalesData
   */
  public void saveData(AppUser user) {
    em.persist(user);
    em.flush();
  }
  
  /**
   * Get user by name
   * @param name
   * @return user
   */
  public AppUser getUserByName(String name) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<AppUser> cq = cb.createQuery(AppUser.class);

    Root<AppUser> userData = cq.from(AppUser.class);
    cq.select(userData);
    cq.where(cb.equal(userData.get("name"), name));

    TypedQuery<AppUser> q = em.createQuery(cq);
    AppUser user = q.getResultList().get(0);

    return user;
  }
  
  /**
   * Get all users
   * @return 
   */
  public List<AppUser> getAllUsers() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<AppUser> cq = cb.createQuery(AppUser.class);

    Root<AppUser> userData = cq.from(AppUser.class);
    cq.select(userData);

    TypedQuery<AppUser> q = em.createQuery(cq);
    List<AppUser> users = q.getResultList();

    return users;
  }
  
  
}

package in.al.dashboard.services;

import in.al.dashboard.models.AppUser;
import in.al.dashboard.repos.UserRepository;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

/**
 * Service layer for user objects
 * @author rockyj
 */
@Service
public class UserService {
  
  private static final Log LOG = LogFactory.getLog(UserService.class);

  @Resource
  UserRepository userRepository;
  
  /**
   * Create a user
   * @param userName
   * @param email
   * @param plainPassword 
   */
  public void createUser(String userName, String email, String plainPassword, AppUser.Role role){
    if(isNullOrBlank(userName) || isNullOrBlank(plainPassword) || isNullOrBlank(email))
      throw new RuntimeException("Name / Email / Password cannot be blank!");
    AppUser user = new AppUser();
    user.setName(userName);
    user.setPassword(plainPassword);
    user.setEmail(email);
    user.setActive(Boolean.TRUE);
    user.setToken();
    user.setCreatedOn(DateTime.now().toDate());
    user.setTokenActive(Boolean.FALSE);
    user.setTokenGeneratedOn(DateTime.now().toDate());
    user.setUserRole(role);
    userRepository.saveData(user);
  }

  private boolean isNullOrBlank(String userName) {
    return userName == null || userName.trim().length() == 0;
  }
  
}

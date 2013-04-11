package in.al.dashboard.restservices;

import in.al.dashboard.models.AppUser;
import in.al.dashboard.services.UserService;
import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * User signup service
 * @author rockyj
 */
@Component
@Path("/signup")
public class SignupService {
  
  private static final Log LOG = LogFactory.getLog(SignupService.class);
  
  @Resource
  UserService userService;
  
  /**
   * Sign up a user
   * @param userName
   * @param email
   * @param password
   * @param passwordConfirmation
   * @return 
   */
  @POST
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public String signup(@FormParam("username") String userName, @FormParam("email") String email, @FormParam("password") String password, @FormParam("password_conf") String passwordConfirmation) {
    if(!password.equals(passwordConfirmation))
      return "{\"message\": \"Please ensure that the passwords are same!\"}";
    try {
      userService.createUser(userName, email, password, AppUser.Role.User);
    } catch (Exception e) {
      return "{\"message\": \"" + e.getMessage() + "\"}";
    }
    return "{\"message\": \"User created successfully!\"}";
  }
  
}

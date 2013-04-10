package in.al.dashboard.services;

import in.al.dashboard.models.AppUser;
import in.al.dashboard.repos.UserRepository;
import java.io.IOException;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author rockyj
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UserServiceTest {
  
  @Resource
  private UserService userService;
  
  @Resource
  private UserRepository userRepository;

  @Before
  public void setUp() {
  }
  
  @Test
  public void shouldParseAndPersistFile() throws IOException {
    Assert.assertTrue(userRepository.getAllUsers().isEmpty());
    
    userService.createUser("rocky", "rocky@example.com", "123456", AppUser.Role.Admin);
    
    Assert.assertNotNull(userRepository.getUserByName("rocky"));
  }
  
}

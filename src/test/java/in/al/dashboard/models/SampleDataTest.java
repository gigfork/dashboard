package in.al.dashboard.models;

import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author rockyj
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class SampleDataTest {
  
  @Resource
  private SampleData data;
  
  @Before
  public void setUp(){
  }
  
  @Test
  public void sampleDataShouldNotBeNull() {
    Assert.assertNotNull(data);
  }
  
}

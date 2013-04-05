package in.al.dashboard.repos;

import in.al.dashboard.models.SampleData;
import javax.annotation.Resource;
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
public class SampleDataRepositoryTest {
  
  @Resource
  private SampleDataRepository sampleDataRepository;
  
  @Before
  public void setUp(){
  }
  
  @Test
  public void sampleDataShouldNotBeNull() {
    SampleData sample = new SampleData();
    sample.setSomeValue(100L);
    sampleDataRepository.savePost(sample);
  }
  
}

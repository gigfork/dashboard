package in.al.dashboard.services;

import in.al.dashboard.models.SampleData;
import in.al.dashboard.repos.SampleDataRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Sample Data Services
 * @author rockyj
 */
@Service
public class SampleDataService {
  
  @Resource
  SampleDataRepository sampleDataRepository;
  
  /**
   * Get some sample data
   * @return 
   */
  public List<SampleData> getSampleData() {
    for(int i=0; i < 10; i++){
      SampleData sd = new SampleData();
      sd.setSomeValue(new Long(i));
      sampleDataRepository.saveData(sd);
    }
    return sampleDataRepository.getData();
  }
  
}

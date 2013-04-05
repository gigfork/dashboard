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
    return sampleDataRepository.getData();
  }
  
}

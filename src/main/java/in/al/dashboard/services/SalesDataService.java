package in.al.dashboard.services;

import in.al.dashboard.models.SalesData;
import in.al.dashboard.repos.SalesDataRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Sample Data Services
 * @author rockyj
 */
@Service
public class SalesDataService {
  
  @Resource
  SalesDataRepository salesDataRepository;
  
  /**
   * Get sales data
   * @return 
   */
  public List<SalesData> getSalesData() {
    List salesData = salesDataRepository.getSalesData();
    List<SalesData> sdl = new ArrayList<SalesData>();
    for (Iterator it = salesData.iterator(); it.hasNext();) {
      Object[] data = (Object[]) it.next();
      SalesData sd = new SalesData();
      sd.setUnitsOfSale((Long) data[0]);
      sd.setMonthOfSale((String) data[1]);
      sd.setYearOfSale((Integer) data[2]);
      sdl.add(sd);
    }
    return sdl;
  }
  
}

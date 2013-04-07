package in.al.dashboard.services;

import in.al.dashboard.models.SalesData;
import in.al.dashboard.repos.SalesDataRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Handle the file upload and persist the data
 * @author rockyj
 */
@Service
public class UploadedFile {
  
  private static final Logger LOGGER = Logger.getLogger(UploadedFile.class.getCanonicalName());
  
  private File file;
  
  @Resource
  SalesDataRepository salesDataRepository;
  
  /**
   * Parse and persist the file
   */
  public void parseAndPersist() {
    String line;
    try {
      BufferedReader br = new BufferedReader(new FileReader(this.file));
      while ((line = br.readLine()) != null) {
        String[] data = line.split(",");
        SalesData sd = new SalesData();
        sd.setYearOfSale(new Integer(data[0].trim()));
        sd.setMonthOfSale(data[1].trim());
        sd.setUnitsOfSale(new Long(data[2].trim()));
        salesDataRepository.saveData(sd);
      }
    } catch(Exception ex) {
      LOGGER.log(Level.SEVERE, ex.getMessage());
    }
  }

  public void setFile(File savedFile) {
    this.file = savedFile;
  }
  
  
}

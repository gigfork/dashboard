package in.al.dashboard.services;

import in.al.dashboard.repos.SalesDataRepository;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Resource;
import org.apache.commons.io.FileUtils;
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
public class UploadedFileTest {
  
  @Resource
  private UploadedFile uploadedFile;
  
  @Resource
  private SalesDataRepository salesDataRepository;

  @Before
  public void setUp() {
  }
  
  @Test
  public void shouldParseAndPersistFile() throws IOException {
    Assert.assertTrue(salesDataRepository.getSalesData().isEmpty());
    InputStream resource = getClass().getResourceAsStream("/sample");
    final File tmpFile = new File(FileUtils.getTempDirectoryPath() + "/sample");
    FileUtils.copyInputStreamToFile(resource, tmpFile);
    uploadedFile.setFile(tmpFile);
    uploadedFile.parseAndPersist();
    Assert.assertTrue(salesDataRepository.getSalesData().size() == 24);
  }
  
}

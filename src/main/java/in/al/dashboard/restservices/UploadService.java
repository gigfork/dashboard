package in.al.dashboard.restservices;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import in.al.dashboard.services.UploadedFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Handles file upload
 *
 * @author rockyj
 */
@Component
@Path("/uploadFile")
public class UploadService {
  
  private static final Log LOG = LogFactory.getLog(UploadService.class);
  
  @Resource
  UploadedFile uploadedFile;
  
  /**
   * Rubbish
   * @param uploadedInputStream
   * @param fileDetail
   * @return 
   */
  @POST
  @Path("/")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces(MediaType.APPLICATION_JSON)
  public String uploadFile(@FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {
    String uploadedFilelocation = "/tmp/" + fileDetail.getFileName();
    File outputFile = writeToFile(uploadedInputStream, uploadedFilelocation);
    uploadedFile.setFile(outputFile);
    uploadedFile.parseAndPersist();
    String output = "{\"message\": \"File uploaded to " + uploadedFilelocation + "\"}";
    return output;
  }
  
  private File writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {
    File file = new File(uploadedFileLocation);
    LOG.debug("creating file ...");
    try {
      OutputStream out = new FileOutputStream(file);
      int read = 0;
      byte[] bytes = new byte[1024];
      out = new FileOutputStream(new File(uploadedFileLocation));
      while ((read = uploadedInputStream.read(bytes)) != -1) {
        out.write(bytes, 0, read);
      }
      out.flush();
      out.close();
    } catch (IOException e) {
      LOG.error(e.getMessage());
    }
   return file;
  }

}

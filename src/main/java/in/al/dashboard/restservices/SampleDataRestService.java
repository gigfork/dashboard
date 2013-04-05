package in.al.dashboard.restservices;

import in.al.dashboard.models.SampleData;
import in.al.dashboard.services.SampleDataService;
import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

/**
 * Sample data rest service
 * @author rockyj
 */
@Component
@Path("/sampledata")
public class SampleDataRestService {
  
    @Resource
    SampleDataService sampleDataService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SampleData> getSampleData() {
      return sampleDataService.getSampleData();
    }
  
}

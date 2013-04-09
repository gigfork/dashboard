package in.al.dashboard.restservices;

import in.al.dashboard.models.SalesData;
import in.al.dashboard.services.SalesDataService;
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
@Path("/salesdata")
public class SampleDataRestService {
  
    @Resource
    SalesDataService salesDataService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SalesData> getSampleData() {
      return salesDataService.getSalesData();
    }
  
}

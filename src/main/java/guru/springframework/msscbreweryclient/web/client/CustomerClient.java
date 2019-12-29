package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "sfg.customer", ignoreUnknownFields = false)
@Component
public class CustomerClient {
    public final String Customer_PATH_V1="/api/v1/customer/";
    public final RestTemplate restTemplate;
    public String apihost;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public CustomerDto getCutomerNamebyID(UUID uuid) {
        return restTemplate.getForObject(apihost+Customer_PATH_V1 +uuid.toString(), CustomerDto.class);
    }
    public URI saveNewCustomer(CustomerDto customerDto)
    {
        return restTemplate.postForLocation(apihost+Customer_PATH_V1,customerDto);
    }
    public void updateCustomer(UUID uuid,CustomerDto customerDto)
    {
        restTemplate.put(apihost+Customer_PATH_V1 + uuid.toString(), customerDto);
    }
    public void deleteCustomer(UUID uuid)
    {
     restTemplate.delete(apihost+Customer_PATH_V1 + uuid.toString());
    }




}

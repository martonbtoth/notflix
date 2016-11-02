package hu.martontoth.notflix.connector;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Márton Tóth
 */
@FeignClient("ContentManagementService")
public interface ContentManagementConnector {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String getAhoy();

}

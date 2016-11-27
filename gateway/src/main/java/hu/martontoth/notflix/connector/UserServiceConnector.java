package hu.martontoth.notflix.connector;

import hu.martontoth.notflix.model.NotflixUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Márton Tóth
 */
@FeignClient("UserService")
public interface UserServiceConnector {

    @RequestMapping(method = RequestMethod.GET, value = "/internal/{name}")
    NotflixUser getUserByName(@PathVariable("name") String username);

}

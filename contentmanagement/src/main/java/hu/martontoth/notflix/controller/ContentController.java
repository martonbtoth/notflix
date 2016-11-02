package hu.martontoth.notflix.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Márton Tóth
 */
@RestController
public class ContentController {

    @Autowired
    private Environment environment;

    @RequestMapping("/")
    public String example() {
        return "Ahoy from port " + environment.getProperty("local.server.port") + "!";
    }

}

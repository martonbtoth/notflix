package hu.martontoth.notflix.controller;

import hu.martontoth.notflix.connector.ContentServiceConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Márton Tóth
 */
@RestController
public class AhoyController {

    @Autowired
    private ContentServiceConnector contentManagementConnector;

    @RequestMapping("ahoy")
    public String ahoy() {
        return contentManagementConnector.getAhoy();
    }

}

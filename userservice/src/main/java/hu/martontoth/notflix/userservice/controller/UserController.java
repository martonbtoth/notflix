package hu.martontoth.notflix.userservice.controller;

import hu.martontoth.notflix.userservice.model.NotflixUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @RequestMapping("{name}")
    public NotflixUser getUserByName(@PathVariable("name") String username) {
        return new NotflixUser(username, "$2a$04$MlU.pWURrDSwXZSyznuOlOHA2TmpDx7qyDf6AF.ADpRfmjl5.fi/m");
    }

}

package hu.martontoth.notflix.userservice.controller;

import hu.martontoth.notflix.userservice.model.NotflixUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("internal/{name}")
    public NotflixUser getUserByName(@PathVariable("name") String username) {
        // pass: a
        return new NotflixUser(username, "$2a$04$bvasbJiJL5AAxORxRwrumOs7slVGGndZ6SyPrvf8Ggkan9B.f9pS6");
    }

    @RequestMapping("me")
    public User me() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}

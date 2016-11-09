package hu.martontoth.notflix.config;

import hu.martontoth.notflix.connector.UserServiceConnector;
import hu.martontoth.notflix.model.NotflixUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class NotflixUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceConnector userServiceConnector;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NotflixUser notflixUser = userServiceConnector.getUserByName(username);
        if (notflixUser == null) {
            throw new UsernameNotFoundException("User not found in UserService.");
        }
        return new User(
                notflixUser.getUsername(),
                notflixUser.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("USER"))
        );
    }
}

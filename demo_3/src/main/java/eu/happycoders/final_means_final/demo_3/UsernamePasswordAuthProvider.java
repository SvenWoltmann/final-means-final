package eu.happycoders.final_means_final.demo_3;

import java.util.List;
import java.util.Map;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class UsernamePasswordAuthProvider implements AuthenticationProvider {

    /** A user account with its password and granted authorities. */
    private record User(String password, List<GrantedAuthority> authorities) {
    }

    // Both users have an empty authorities list - neither of them is an admin.
    private static final Map<String, User> USERS = Map.of(
            "alice", new User("s3cr3t", List.of()),
            "bob", new User("p@ssw0rd", List.of())
    );

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (isEmpty(username) || isEmpty(password)) {
            throw new BadCredentialsException("Empty username or password");
        }

        User user = USERS.get(username);
        if (user != null && user.password().equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password, user.authorities());
        }

        throw new BadCredentialsException("Invalid username or password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}

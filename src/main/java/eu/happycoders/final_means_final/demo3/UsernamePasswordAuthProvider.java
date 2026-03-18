package eu.happycoders.final_means_final.demo3;

import eu.happycoders.final_means_final_lib.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UsernamePasswordAuthProvider implements AuthenticationProvider {

    private static final Map<String, String> USERS = Map.of(
            "alice", "s3cr3t",
            "bob", "p@ssw0rd"
    );

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new BadCredentialsException("Empty username or password");
        }

        if (USERS.containsKey(username) && USERS.get(username).equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password, List.of());
        }

        throw new BadCredentialsException("Invalid username or password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

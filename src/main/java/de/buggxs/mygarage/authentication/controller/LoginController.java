package de.buggxs.mygarage.authentication.controller;

import de.buggxs.mygarage.authentication.model.requests.AuthenticationRequest;
import de.buggxs.mygarage.authentication.model.response.AuthenticationResponse;
import de.buggxs.mygarage.authentication.model.response.JwtResponse;
import de.buggxs.mygarage.authentication.user.User;
import de.buggxs.mygarage.authentication.user.UserDetailsService;
import de.buggxs.mygarage.authentication.utils.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/login")
@AllArgsConstructor
@Slf4j
public class LoginController {

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {

        Authentication authentication = null;
        try {
            authentication = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        } catch (Exception e) {
            log.error("Authentication went wrong.");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        String jwtToken = jwtUtil.generateToken(userDetails);

        if (authentication != null) {
            User user = (User) authentication.getPrincipal();
            return ResponseEntity.ok(new AuthenticationResponse(jwtToken,
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getAuthorities()
                            .stream()
                            .map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList())
            ));
        }
        return ResponseEntity.ok(new JwtResponse(jwtToken));

    }

    private Authentication authenticate(String username, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}

package de.format.CarIdent.controller.auth;

import de.format.CarIdent.database.RoleRepository;
import de.format.CarIdent.database.UserRepository;
import de.format.CarIdent.exception.ContractDatabaseException;
import de.format.CarIdent.model.auth.Role;
import de.format.CarIdent.model.auth.User;
import de.format.CarIdent.model.requests.AuthenticationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/register")
@AllArgsConstructor
public class RegisterController {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> index(@RequestBody AuthenticationRequest authenticationRequest)
    {
        Role role = roleRepository
                .findById(1L)
                .orElseThrow(() -> new ContractDatabaseException("Es konnte keine passende Rolle gefunden werden."));

        User user = new User(
                authenticationRequest.getUsername(),
                passwordEncoder.encode(authenticationRequest.getPassword()),
                "test@gmail.com",
                false,
                false,
                false,
                true,
                role
        );
        userRepository.save(user);
        return ResponseEntity.ok("User successfully registered");
    }

}

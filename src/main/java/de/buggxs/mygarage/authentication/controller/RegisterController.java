package de.buggxs.mygarage.authentication.controller;

import de.buggxs.mygarage.authentication.model.requests.AuthenticationRequest;
import de.buggxs.mygarage.authentication.role.Role;
import de.buggxs.mygarage.authentication.role.RoleRepository;
import de.buggxs.mygarage.authentication.user.User;
import de.buggxs.mygarage.authentication.user.UserRepository;
import de.buggxs.mygarage.exception.ContractDatabaseException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/register")
@AllArgsConstructor
public class RegisterController {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> index(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        Role role = roleRepository
                .findById(1L)
                .orElseThrow(() -> new ContractDatabaseException("Es konnte keine passende Rolle gefunden werden."));

        User user = new User(
                authenticationRequest.getUsername(),
                "test@gmail.com",
                passwordEncoder.encode(authenticationRequest.getPassword())
        );
        userRepository.save(user);
        return ResponseEntity.ok("User successfully registered");
    }
}

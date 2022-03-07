package de.format.CarIdent.controller.auth;

import de.format.CarIdent.role.RoleRepository;
import de.format.CarIdent.user.UserRepository;
import de.format.CarIdent.exception.ContractDatabaseException;
import de.format.CarIdent.role.Role;
import de.format.CarIdent.user.User;
import de.format.CarIdent.model.requests.AuthenticationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/register")
@AllArgsConstructor
public class RegisterController {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> index(@Valid @RequestBody AuthenticationRequest authenticationRequest)
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

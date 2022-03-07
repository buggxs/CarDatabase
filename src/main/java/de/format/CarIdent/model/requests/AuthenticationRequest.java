package de.format.CarIdent.model.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AuthenticationRequest {

    @NotBlank(message = "Ein Username wird benötigt.")
    private String username;

    @NotBlank(message = "Ein Passwort wird benötigt.")
    private String password;

}

package de.buggxs.mygarage.authentication.model.response;

import lombok.Data;

import java.util.List;

@Data
public class AuthenticationResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> permissions;

    public AuthenticationResponse(String token, Long id, String username, String email, List<String> permissions) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.permissions = permissions;
    }

}

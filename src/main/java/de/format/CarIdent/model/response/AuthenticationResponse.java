package de.format.CarIdent.model.response;

import lombok.Data;

import java.util.List;

@Data
public class AuthenticationResponse {

    private String tocken;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> permissions;

    public AuthenticationResponse(String tocken, Long id, String username, String email, List<String> permissions) {
        this.tocken = tocken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.permissions = permissions;
    }

}

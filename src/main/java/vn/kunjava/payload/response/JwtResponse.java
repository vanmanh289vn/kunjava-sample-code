package vn.kunjava.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
//    private String type = "Bearer";
//    private Long id;
//    private String username;
//    private String email;
//    private List<String> roles;
    private UserResponse user;

//    public JwtResponse(String token, Long id, String username, String email, List<String> roles) {
//        this.token = token;
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.roles = roles;
//    }


    public JwtResponse(String token, UserResponse user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setAccessToken(String token) {
        this.token = token;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    //    public String getTokenType() {
//        return type;
//    }
//
//    public void setTokenType(String tokenType) {
//        this.type = tokenType;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public List<String> getRoles() {
//        return roles;
//    }

}

public class LoginResponse {
    private String message;
    private String token;  // ici un JWT ou autre token d’authentification

    public LoginResponse() {}

    public LoginResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    // Getters & setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}

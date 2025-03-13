
package AdminPackage;

public class Admin {
    private int adminId;
    private String username;
    private String email;
    private String password; // Added password field

    // Constructor with adminId
    public Admin(int adminId, String username, String email, String password) {
        this.adminId = adminId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Constructor without adminId (if needed)
    public Admin(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters
    public int getAdminId() {
        return adminId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { // Added password getter
        return password;
    }

    // Setters (if needed)
    public void setPassword(String password) {
        this.password = password;
    }
}



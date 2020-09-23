package del.ac.id.request;

import del.ac.id.model.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
public class RegisterRequest {
    String nama;
    String username;
    String password;
    private RoleName roleName;

    public RegisterRequest(String nama, String username, String password, RoleName roleName) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.roleName = roleName;
    }

    public RegisterRequest() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}

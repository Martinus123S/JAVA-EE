package del.ac.id.model;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name="username")
    private String username;

    @Column(name = "nama")
    private String nama;

    @Column(name = "password")
    private String password;


    @Column(name = "role")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "users_id",referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Set<Roles> roles = new HashSet<>();
    public User(){

    }
    public User(String nama, String password,String username) {
        this.nama = nama;
        this.password = password;
        this.username = username;
    }

    public User(String nama, String password, String username, Set<Roles> roles) {
        this.nama = nama;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}

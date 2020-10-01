package kelompok1._HappyTravelling.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "password")
    private String password;

    @Column(name = "roleid")
    private int roleId;

    public User(String username, String fullName, String password, int roleId) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.roleId = roleId;
    }
}

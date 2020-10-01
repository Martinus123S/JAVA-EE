package del.ac.id.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @Column(name = "users_id")
    String users_id;

    @Column(name = "role_id")
    Long role_id;
}

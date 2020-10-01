package del.ac.id.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "historyUser")
public class ListUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "viewed")
    private LocalDateTime viewed;

    public ListUser(String username, LocalDateTime viewed) {
        this.username = username;
        this.viewed = viewed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getViewed() {
        return viewed;
    }

    public void setViewed(LocalDateTime viewed) {
        this.viewed = viewed;
    }
}

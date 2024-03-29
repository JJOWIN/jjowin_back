package back.jjowin.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class UserSkill extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "user_skill_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    private String name;

    private int level;

    public void setUser(User user) {
        this.user = user;
        user.getUserSkills().add(this);
    }
}

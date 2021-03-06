package back.jjowin.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter @Setter
public class Project extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "project_id")
    private Long id;

    private String name;

    private String category;
    
    private String contestUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id")
    private User leader;

    private String schoolName;

    private String description;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;    //프로젝트 진행상태 [INSPECTION, PROGRESS, COMPLETION]

    private int likeCount;

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToMany(mappedBy = "project")
    private List<ProjectSkill> projectSkills = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<RecruitInfo> recruitInfos = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<MemberInfo> memberInfos = new ArrayList<>();

//    private List<Comment> comments = new ArrayList<>();

}

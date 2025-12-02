package bd.edu.seu.hibernateassignment.model1;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="students")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinTable (
            name="student_course_mapping",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name ="course_id")
    )
    private List<Course> courses;

    @ElementCollection
    @Column(name="emails")
    @CollectionTable(name="student_email",joinColumns = @JoinColumn(name="student_id"))
    private List<String>email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="profile_id")
    private Profile profile;

}

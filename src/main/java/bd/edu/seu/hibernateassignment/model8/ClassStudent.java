package bd.edu.seu.hibernateassignment.model8;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "class_student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int studentCode;
    private String email;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
}

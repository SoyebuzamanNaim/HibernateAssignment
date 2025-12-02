package bd.edu.seu.hibernateassignment.model7;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistory {
    private String bloodType;
    private String allargies;
    private String lastCheckup;
    private String heartCondition;
}

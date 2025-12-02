package bd.edu.seu.hibernateassignment.model5;

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
public class AuditInfo {
    private String createdBy;
    private String createAt;
    private String updateAt;
}

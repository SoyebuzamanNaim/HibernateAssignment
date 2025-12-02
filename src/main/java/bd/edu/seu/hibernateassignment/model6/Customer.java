package bd.edu.seu.hibernateassignment.model6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "customer_city")),
            @AttributeOverride(name = "street", column = @Column(name = "customer_street")),
            @AttributeOverride(name = "country", column = @Column(name = "customer_country"))
    })
    private Address customerAddress;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<CustomerOrder> customerOrders;
}

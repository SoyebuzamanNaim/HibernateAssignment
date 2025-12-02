package bd.edu.seu.hibernateassignment.model2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "book_autor_mapping",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "publisher_city")),
            @AttributeOverride(name = "street", column = @Column(name = "publisher_street")),
            @AttributeOverride(name = "country", column = @Column(name = "publisher_country"))
    })
    private Address publisherAddress;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "isbn_id")
    private ISBNRegistration isbn;
}

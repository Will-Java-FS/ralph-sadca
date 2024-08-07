package com.revature.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // this annotations tells us that the class is gonna be entity mapped to DB
@Data // this Annotation from Lombok lib will auto generate teh getter and setters for
// us
@Table(name = "items") // the table annotation specifies the name of teh table in our DB
// that is going to correspond to our entity
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id // makes the id field the primary key of table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // basically tells us that the id value is auto generated by the
    // DB
    @Column(name="id",updatable = false)
    private Long id;

    // the @Column annotation is used to specify the properties of a column in a
    // table
    // so here we are stating that these fields are nullable = false which means
    // they CANT be null in the DB
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean status;

    // The @ManyToOne annotation indicates the relationship between the item and
    // user
    // A user can have many items.
    @ManyToOne
    // The @JoinColumn specifies the foriegn key column name in the items table
    // that ref the primary key of the users table
    @JoinColumn(name = "user_id")
    private User user;
}

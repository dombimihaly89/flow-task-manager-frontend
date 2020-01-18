package hu.flowacademy.flowtaskmanager.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer rating;

    public Rating(Integer rating) {
        this.rating = rating;
    }
}

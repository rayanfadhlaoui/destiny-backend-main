package com.learning.springsecuritybasic.model.persistence.character;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "races")
@Getter
@Setter
public class RaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

}

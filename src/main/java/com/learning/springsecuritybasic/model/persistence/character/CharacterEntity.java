package com.learning.springsecuritybasic.model.persistence.character;

import com.learning.springsecuritybasic.model.common.character.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "characters")
@Getter
@Setter
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "birthdate")
    private String birthdate;

    private Gender gender;

    @Column(name = "username", length = 50)
    private String username;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private RaceEntity race;
}

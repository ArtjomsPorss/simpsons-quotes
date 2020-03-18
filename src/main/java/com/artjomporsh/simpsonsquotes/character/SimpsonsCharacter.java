package com.artjomporsh.simpsonsquotes.character;

import com.artjomporsh.simpsonsquotes.common.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "simpsons_character")
public class SimpsonsCharacter extends BaseEntity {

    private String firstName;
    private String lastName;
    private String picture;
    private Integer age;

}

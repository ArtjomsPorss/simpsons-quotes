package com.artjomporsh.simpsonsquotes.character;

import com.artjomporsh.simpsonsquotes.common.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "characters")
public class SimpsonsCharacter extends BaseEntity {

    private String firstName;
    private String lastName;
    private String picture;
    private Integer age;

}

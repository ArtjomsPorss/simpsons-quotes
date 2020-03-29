package com.artjomporsh.simpsonsquotes.quotes;

import com.artjomporsh.simpsonsquotes.common.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "quotes")
public class Quote extends BaseEntity {

    String character;
    String phrase;
}

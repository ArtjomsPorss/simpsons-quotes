package com.artjomporsh.simpsonsquotes.common;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class BaseEntity {
    @Id
    private String _id;
}

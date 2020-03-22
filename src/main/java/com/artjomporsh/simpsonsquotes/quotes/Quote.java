package com.artjomporsh.simpsonsquotes.quotes;

import com.artjomporsh.simpsonsquotes.common.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "simpsons_quotes")
public class Quote extends BaseEntity {
    @Column(name = "character")
    String character;
    @Column(name = "quote")
    String quote;
}

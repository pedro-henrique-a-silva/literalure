package com.literalura.LiterAlura.service.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.literalura.LiterAlura.entity.Author;

public record AuthorFromDbDto(
    Long id,
    String name,
    Long birthYear,
    Long deathYear
) {

  public static AuthorFromDbDto fromEntity(Author author) {
    return new AuthorFromDbDto(
        author.getId(),
        author.getName(),
        author.getBirthYear(),
        author.getDeathYear()
    );
  }
}

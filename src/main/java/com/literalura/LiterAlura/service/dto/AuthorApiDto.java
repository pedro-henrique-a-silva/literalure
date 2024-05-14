package com.literalura.LiterAlura.service.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.literalura.LiterAlura.entity.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorApiDto(
    @JsonAlias("name") String name,
    @JsonAlias("birth_year") Long birthYear,
    @JsonAlias("death_year") Long deathYear
) {

  public Author toEntity() {
    return new Author(
        name,
        birthYear,
        deathYear
    );
  }
}

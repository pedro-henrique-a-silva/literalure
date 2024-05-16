package com.literalura.LiterAlura.service.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.literalura.LiterAlura.entity.Book;
import com.literalura.LiterAlura.entity.Language;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookApiDto(
     @JsonAlias("id") Long id,
     @JsonAlias("title") String title,
     @JsonAlias("authors") List<AuthorApiDto> authors,
     @JsonAlias("languages") List<String> languages,
     @JsonAlias("download_count") Integer download_count
) {
}

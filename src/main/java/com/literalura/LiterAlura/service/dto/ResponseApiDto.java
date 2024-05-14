package com.literalura.LiterAlura.service.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseApiDto(
    @JsonAlias("results") List<BookApiDto> results
) {

}

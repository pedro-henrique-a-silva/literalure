package com.literalura.LiterAlura.service.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.literalura.LiterAlura.entity.Book;
import java.util.List;

public record BooksFromDbDto(
   Long id,
   String title,
   Integer download_count
) {

  public static BooksFromDbDto fromEntity(Book book) {
    return new BooksFromDbDto(
        book.getId(),
        book.getTitle(),
        book.getDownloadCount()
    );
  }
}

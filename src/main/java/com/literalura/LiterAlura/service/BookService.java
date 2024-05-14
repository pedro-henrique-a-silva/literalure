package com.literalura.LiterAlura.service;

import com.literalura.LiterAlura.entity.Author;
import com.literalura.LiterAlura.entity.Book;
import com.literalura.LiterAlura.entity.Language;
import com.literalura.LiterAlura.repository.AuthorRepository;
import com.literalura.LiterAlura.repository.BookRepository;
import com.literalura.LiterAlura.repository.LanguageRepository;
import com.literalura.LiterAlura.service.dto.AuthorApiDto;
import com.literalura.LiterAlura.service.dto.BookApiDto;
import com.literalura.LiterAlura.service.dto.ResponseApiDto;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final ConverteDados converteDados;

  private final BookRepository bookRepository;

  private final AuthorRepository authorRepository;

  private final LanguageRepository languageRepository;

  @Autowired
  public BookService(ConverteDados converteDados, BookRepository bookRepository,
      AuthorRepository authorRepository, LanguageRepository languageRepository) {
    this.converteDados = converteDados;
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
    this.languageRepository = languageRepository;
  }

  public List<BookApiDto> getBooksFromApiByTitle(
      String bookName
  ) throws IOException, InterruptedException {
    ConsumoApi api = new ConsumoApi();

    String responseJson = api.obterDados("?search="+ bookName);
    ResponseApiDto response = converteDados.obterDados(responseJson, ResponseApiDto.class);

    registerBookData(response.results());
    System.out.println("Dados cadastrados");

    return response.results();
  }

  private void registerBookData(List<BookApiDto> books) {
    for(BookApiDto book : books) {
      Book newBook = new Book();

      newBook.setTitle(book.title());
      newBook.setDownloadCount(book.download_count());

      List<Author> newAuthor = book.authors().stream().map(AuthorApiDto::toEntity).toList();

      authorRepository.saveAll(newAuthor);

      List<Language> newLenguages = book.languages().stream().map(Language::new).toList();
      languageRepository.saveAll(newLenguages);

      newBook.setAuthors(newAuthor);
      newBook.setLanguages(newLenguages);

      bookRepository.save(newBook);
    }
  }
}

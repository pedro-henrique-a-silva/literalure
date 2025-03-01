package com.literalura.LiterAlura;

import com.literalura.LiterAlura.entity.Book;
import com.literalura.LiterAlura.service.BookService;
import com.literalura.LiterAlura.service.ConsumoApi;
import com.literalura.LiterAlura.service.ConverteDados;
import com.literalura.LiterAlura.service.dto.AuthorFromDbDto;
import com.literalura.LiterAlura.service.dto.BookApiDto;
import com.literalura.LiterAlura.service.dto.BooksFromDbDto;
import com.literalura.LiterAlura.service.dto.ResponseApiDto;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Principal {

  private final Scanner scanner = new Scanner(System.in);
  private final BookService bookService;

  public Principal(BookService bookService) {
    this.bookService = bookService;
  }

  public void execute() throws IOException, InterruptedException {
    int option = -1;

    while (option != 0) {
      var menu = """
                    1 - buscar livro pelo titulo
                    2 - listar livros registrados
                    3 - listar autores registrados
                    4 - listar autores vivos em um determinado ano
                    5 - listar livros em um determinado idioma

                    0 - Sair
                   """;


      System.out.println(menu);
      option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {
        case 1:
          buscaLivroPeloTitulo();
          break;
        case 2:
          listarLivrosRegistrados();
          break;
        case 3:
          listarAutoresRegistrados();
          break;
        case 4:
          listarAutoresVivosEmUmDeterminadoAno(); 
          break;
        case 5:
          System.out.println("opção 5");
          break;

        case 0:
          System.out.println("Saindo ...");
      }
    }
  }

  private void buscaLivroPeloTitulo() throws IOException, InterruptedException {
    System.out.println("Digite o nome do titulo.");
    String titleName = scanner.nextLine();

    List<BookApiDto> books = bookService.getBooksFromApiByTitle("dom+casmurro");
  }

  private void listarLivrosRegistrados() {
    List<BooksFromDbDto> books = bookService.getAllBooks();
    books.forEach(System.out::println);
  }

  private void listarAutoresRegistrados() {
    List<AuthorFromDbDto> books = bookService.getAllAuthors();
    books.forEach(System.out::println);
  }

  public void listarAutoresVivosEmUmDeterminadoAno() {
    System.out.println("Digite um ano.");
    Integer year = scanner.nextInt();

    List<AuthorFromDbDto> books = bookService.getAllAuthorsByBirthYear(year);
    books.forEach(System.out::println);
  }
}

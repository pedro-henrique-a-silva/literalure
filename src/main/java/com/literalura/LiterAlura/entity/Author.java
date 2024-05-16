package com.literalura.LiterAlura.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors", cascade = CascadeType.ALL)
  private List<Book> books;

  private Long birthYear;

  private Long deathYear;

  public Author() {
  }

  public Author(String name, Long birthYear, Long deathYear) {
    this.name = name;
    this.birthYear = birthYear;
    this.deathYear = deathYear;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(Long birthYear) {
    this.birthYear = birthYear;
  }

  public Long getDeathYear() {
    return deathYear;
  }

  public void setDeathYear(Long deathYear) {
    this.deathYear = deathYear;
  }
}

package com.literalura.LiterAlura.repository;

import com.literalura.LiterAlura.entity.Author;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
  List<Author> findByDeathYearLessThanAndGreaterThanBirthYear(Integer deatyYear);
}
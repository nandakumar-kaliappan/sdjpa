package com.knkweb.sdjpa.repository;

import com.knkweb.sdjpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

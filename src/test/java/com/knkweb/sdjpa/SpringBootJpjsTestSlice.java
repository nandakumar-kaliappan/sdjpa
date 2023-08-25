package com.knkweb.sdjpa;

import com.knkweb.sdjpa.domain.Book;
import com.knkweb.sdjpa.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ComponentScan(basePackages = {"com.knkweb.sdjpa.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJpjsTestSlice {
    @Autowired
    BookRepository bookRepository;

    @Test
    @Order(1)
    @Commit
    void contextLoads() {
        Long countBefore = bookRepository.count();
        assertThat(countBefore).isGreaterThan(0);
        bookRepository.save(Book.builder().title("dfkjv").isbn("some isbn").build());
        assertThat(bookRepository.count()).isGreaterThan(countBefore);
    }

    @Test
    @Order(2)
    public void testContinues(){
        assertThat(bookRepository.count()).isGreaterThan(2);
    }
}

package com.knkweb.sdjpa;

import com.knkweb.sdjpa.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SdjpaApplicationTests {

    @Autowired
    BookRepository bookRepository;


    @Test
    void contextLoads() {
        Long countBefore = bookRepository.count();
        assertThat(countBefore).isGreaterThan(0);

    }



}

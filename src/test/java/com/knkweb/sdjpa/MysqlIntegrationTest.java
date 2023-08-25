package com.knkweb.sdjpa;

import com.knkweb.sdjpa.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.knkweb.sdjpa.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  //disables SB auto
// config
public class MysqlIntegrationTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void mysqlTest(){
        assertThat(bookRepository.count()).isGreaterThan(0);
    }
}

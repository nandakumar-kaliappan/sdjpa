package com.knkweb.sdjpa.bootstrap;

import com.knkweb.sdjpa.domain.Author;
import com.knkweb.sdjpa.domain.AuthorUuid;
import com.knkweb.sdjpa.domain.Book;
import com.knkweb.sdjpa.repository.AuthorRepository;
import com.knkweb.sdjpa.repository.AuthorUuidRepository;
import com.knkweb.sdjpa.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"local", "default"})
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorUuidRepository authorUuidRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository,
                           AuthorUuidRepository authorUuidRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.authorUuidRepository = authorUuidRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        Book aa =
                Book.builder().title("Athanaikkum Aasaipadu").isbn("q73re").publisher("isha").build();
        System.out.println("Before save : "+ aa);
        Book savedAa = bookRepository.save(aa);

        Book d =
                Book.builder().title("Death").isbn("er435").publisher("IYC").build();
        Book savedD =bookRepository.save(d);

        Author sadhguru =
                Author.builder().firstName("Jaggi").lastName("Vasudev").build();
        authorRepository.save(sadhguru);

        Author kalki =
                Author.builder().firstName("kalki").lastName("krishnamoorthy").build();
        authorRepository.save(kalki);





        bookRepository.findAll().forEach(book -> {
            System.out.println("id:"+ book.getId()+"  Title:"+book.getTitle());
        });

        authorRepository.findAll().forEach(System.out::println);

        AuthorUuid s =
                AuthorUuid.builder().firstName("Jaggi").lastName("Vasudev").build();
        AuthorUuid savedS = authorUuidRepository.save(s);
        System.out.println(savedS.getId());


    }
}

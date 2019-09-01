package tech.gonzalezfernando.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tech.gonzalezfernando.spring5webapp.model.Author;
import tech.gonzalezfernando.spring5webapp.model.Book;
import tech.gonzalezfernando.spring5webapp.model.Publisher;
import tech.gonzalezfernando.spring5webapp.repositories.AuthorRepository;
import tech.gonzalezfernando.spring5webapp.repositories.BookRepository;
import tech.gonzalezfernando.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        // Authors
        Author eric = new Author("Eric", "Evans");
        Publisher dddPublisher = new Publisher("Harper Collins", "Some Random Place");
        Book dddBook = new Book("Domain Driven Design", "1234", dddPublisher);
        eric.getBooks().add(dddBook);
        dddBook.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(dddPublisher);
        bookRepository.save(dddBook);

        Author rod = new Author("Rod", "Johnson");
        Publisher jdPublisher = new Publisher("Worx", "IDK TBH");
        Book jdBook = new Book("J2EE Development without EJB", "23444", jdPublisher);
        rod.getBooks().add(jdBook);

        authorRepository.save(rod);
        publisherRepository.save(jdPublisher);
        bookRepository.save(jdBook);
    }
}

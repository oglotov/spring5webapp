package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Publisher ababa = new Publisher("Ababagalamaga");
        publisherRepository.save(ababa);
        Book ddd = new Book("Domain Driven Design", "123123", ababa);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(ababa);
        Author rod = new Author("Rod", "Jhonson");
        Book noEJB = new Book("J2EE Development without EJB", "1242353245", ababa);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        ababa.getBooks().add(ddd);
        ababa.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(ababa);
        System.out.println("Started in BootStrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + ababa.getBooks().size());

    }
}

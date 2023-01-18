package com.springdemo.n0webapp.bootstrap;

import com.springdemo.n0webapp.domain.Author;
import com.springdemo.n0webapp.domain.Book;
import com.springdemo.n0webapp.domain.Publisher;
import com.springdemo.n0webapp.repositories.AuthorRepository;
import com.springdemo.n0webapp.repositories.BookRepository;
import com.springdemo.n0webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  // when Spring implements this component
  // that's going to bring it into the Spring context.
  // it will dependency-injection into the constructor
  // for an instance of the author repository and book repository
  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("--- Started in Bootstrap ---");

    // --------------------------------------------------------------------------------

    String[] springIOAddress = { "SpringIO Publishing", "1234 Spring St.", "Spring IO", "SP", "12345" };
    String[] jakartaAddress = { "Jakarta Publishing", "2003 Jakarta Ave.", "Jakarta", "JK", "67890" };

    Publisher springPublisher = new Publisher();

    setPublisher(springPublisher, springIOAddress);

    Publisher jakartaPublisher = new Publisher();

    setPublisher(jakartaPublisher, jakartaAddress);

    publisherRepository.save(springPublisher);
    publisherRepository.save(jakartaPublisher);

    System.out.println("\tPublisher Count: " + publisherRepository.count());

    // --------------------------------------------------------------------------------

    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123123");

    // publish book
    publishBook(eric, ddd, springPublisher);

    // --------------------------------------------------------------------------------

    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "345345");

    // publish book
    publishBook(rod, noEJB, jakartaPublisher);

    // --------------------------------------------------------------------------------

    Author craig = new Author("Craig", "Walls");
    Book springInAction = new Book("Spring in Action", "345345");

    // publish book
    publishBook(craig, springInAction, jakartaPublisher);

    // --------------------------------------------------------------------------------

    System.out.println("\tNumber of Books: " + bookRepository.count());
    System.out.println("\tSpringIO Publisher Number of Books: " + springPublisher.getBooks().size());
    System.out.println("\tJakarta Publisher Number of Books: " + jakartaPublisher.getBooks().size());
  }

  private void publishBook(Author author, Book book, Publisher publisher) {
    author.getBooks().add(book);
    book.getAuthors().add(author);
    book.setPublisher(publisher);
    publisher.getBooks().add(book);

    // will save into h2Database
    authorRepository.save(author);
    bookRepository.save(book);
    publisherRepository.save(publisher);
  }

  private void setPublisher(Publisher publisher, String[] address) {
    publisher.setName(address[0]);
    publisher.setAddressLine(address[1]);
    publisher.setCity(address[2]);
    publisher.setState(address[3]);
    publisher.setZip(address[4]);
  }
}

package curso.dejava.springapp.bootstrap;

import curso.dejava.springapp.domain.Author;
import curso.dejava.springapp.domain.Book;
import curso.dejava.springapp.domain.Publisher;
import curso.dejava.springapp.repositories.AuthorRepository;
import curso.dejava.springapp.repositories.BookRepository;
import curso.dejava.springapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher testPub = new Publisher("Pub1", "test", "test", "test", "test");

        // como publisher tem um set de livros, precisa salvar ele antes de setar ele pra qualquer livro,
        // senao da pau na JPA
        publisherRepository.save(testPub);


        Author felipe = new Author("Felipe", "Bordignon");
        Book testBook = new Book ("Test book", "12313");

        felipe.getBooks().add(testBook);
        testBook.getAuthors().add(felipe);

        testBook.setPublisher(testPub);
        testPub.getBooks().add(testBook);

        authorRepository.save(felipe);
        bookRepository.save(testBook);

        Author juia = new Author("Juia", "Angst");
        Book livroJuia = new Book("Juia", "juuuia");

        livroJuia.setPublisher(testPub);
        testPub.getBooks().add(livroJuia);

        juia.getBooks().add(livroJuia);
        livroJuia.getAuthors().add(juia);

        authorRepository.save(juia);
        bookRepository.save(livroJuia);
        publisherRepository.save(testPub);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books:" + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Publisher number of books: " + testPub.getBooks().size());

    }
}

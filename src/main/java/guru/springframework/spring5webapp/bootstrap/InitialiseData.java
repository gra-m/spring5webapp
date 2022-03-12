package guru.springframework.spring5webapp.bootstrap;


import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Automatically instantiates REPOs on Spring run and saves two object to built in H2Db.

@Component //Makes this a spring managed component.
public class InitialiseData implements CommandLineRunner {
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

public InitialiseData(AuthorRepository authorRepository,
							 BookRepository bookRepository,
							 PublisherRepository publisherRepository) {
	this.authorRepository = authorRepository;
	this.bookRepository = bookRepository;
	this.publisherRepository = publisherRepository;
}

@Override
public void run(String... args) throws Exception {

	Publisher pub = new Publisher("The best","100, WiggleStraat", "Wigwerpen", "Wigwerpene", "2000");
	publisherRepository.save(pub);

	Author pavell = new Author("Eric", "Pavell");
	Book ddd = new Book("Domain Driven Design", "123123");
	pavell.getBooks().add(ddd);
	ddd.getAuthors().add(pavell);
	pub.getBooks().add(ddd);
	ddd.setPublisher(pub);
	authorRepository.save(pavell);
	bookRepository.save(ddd);
	publisherRepository.save(pub);

	Author rod = new  Author("Rod", "Stewart");
	Book eee = new Book("Other people", "12312345");
	rod.getBooks().add(eee);
	eee.getAuthors().add(rod);
	pub.getBooks().add(eee);
	eee.setPublisher(pub);
	authorRepository.save(rod);
	bookRepository.save(eee);
	publisherRepository.save(pub);



	System.out.println("Started in InitialiseData");
	System.out.println("Number of Books " + bookRepository.count());
	System.out.println("Number of Authors " + authorRepository.count());
	System.out.println("Number of Publishers " + publisherRepository.count());
	System.out.println("Publisher no of books " + pub.getBooks().size());

}

}

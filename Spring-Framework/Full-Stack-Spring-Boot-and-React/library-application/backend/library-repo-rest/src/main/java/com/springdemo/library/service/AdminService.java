package com.springdemo.library.service;

import com.springdemo.library.model.Book;
import com.springdemo.library.repository.BookRepository;
import com.springdemo.library.repository.CheckoutRepository;
import com.springdemo.library.repository.ReviewRepository;
import com.springdemo.library.requestmodels.AddBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdminService {

  private final BookRepository bookRepository;
  private final ReviewRepository reviewRepository;
  private final CheckoutRepository checkoutRepository;

  @Autowired
  public AdminService(BookRepository bookRepository,
                      ReviewRepository reviewRepository,
                      CheckoutRepository checkoutRepository) {
    this.bookRepository = bookRepository;
    this.reviewRepository = reviewRepository;
    this.checkoutRepository = checkoutRepository;
  }

  public void increaseBookQuantity(Long bookId) throws Exception {
    Optional<Book> book = bookRepository.findById(bookId);

    if (book.isEmpty()) {
      throw new Exception("Book not found");
    }

    book.get().setCopies(book.get().getCopies() + 1);
    book.get().setCopiesAvailable(book.get().getCopiesAvailable() + 1);

    bookRepository.save(book.get());
  }

  public void decreaseBookQuantity(Long bookId) throws Exception {
    Optional<Book> book = bookRepository.findById(bookId);

    if (book.isEmpty() || book.get().getCopiesAvailable() <= 0 || book.get().getCopies() <= 0) {
      throw new Exception("Book not found or quantity locked");
    }

    book.get().setCopies(book.get().getCopies() - 1);
    book.get().setCopiesAvailable(book.get().getCopiesAvailable() - 1);

    bookRepository.save(book.get());
  }

  public void postBook(AddBookRequest addBookRequest) {
    Book book = new Book();

    book.setTitle(addBookRequest.getTitle());
    book.setAuthor(addBookRequest.getAuthor());
    book.setDescription(addBookRequest.getDescription());
    book.setCopies(addBookRequest.getCopies());
    book.setCopiesAvailable(addBookRequest.getCopies());
    book.setCategory(addBookRequest.getCategory());
    book.setImg(addBookRequest.getImg());

    bookRepository.save(book);
  }

  public void deleteBook(Long bookId) throws Exception {
    Optional<Book> book = bookRepository.findById(bookId);

    if (book.isEmpty()) {
      throw new Exception("Book not found");
    }

    bookRepository.delete(book.get());
    reviewRepository.deleteByBookId(bookId);
    checkoutRepository.deleteByBookId(bookId);
  }
}

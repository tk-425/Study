import { useEffect, useState } from 'react';
import BookModel from '../../../models/BookModel';
import { Pagination } from '../../Utils/Pagination';
import { SpinnerLoading } from '../../Utils/SpinnerLoading';
import { ChangeQuantityOfBook } from './ChangeQuantityOfBook';

export const ChangeQuantityOfBooks = () => {
  // Book
  const [books, setBooks] = useState<BookModel[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  const [httpError, setHttpError] = useState(null);

  // Page
  const [currentPage, setCurrentPage] = useState(1);
  const booksPerPage = 5;
  const [totalAmountOfBooks, setTotalAmountOfBooks] = useState(0);
  const [totalPages, setTotalPages] = useState(0);

  // Delete Book
  const [bookDelete, setBookDelete] = useState(false);

  useEffect(() => {
    const fetchBooks = async () => {
      const url: string = `http://localhost:8080/api/books?page=${
        currentPage - 1
      }&size=${booksPerPage}`;

      const response = await fetch(url);

      // guard clause
      if (!response.ok) {
        throw new Error('Something went wrong');
      }

      // converting response to JSON
      const responseJson = await response.json();

      // JSON to BookModel
      const responseData = responseJson._embedded.books;

      setTotalAmountOfBooks(responseJson.page.totalElements);
      setTotalPages(responseJson.page.totalPages);

      const loadedBooks: BookModel[] = [];

      for (const key in responseData) {
        loadedBooks.push({
          id: responseData[key].id,
          title: responseData[key].title,
          author: responseData[key].author,
          description: responseData[key].description,
          copies: responseData[key].copies,
          copiesAvailable: responseData[key].copiesAvailable,
          category: responseData[key].category,
          img: responseData[key].img,
        });
      }

      setBooks(loadedBooks);
      setIsLoading(false);
    };

    fetchBooks().catch((error: any) => {
      setIsLoading(false);
      setHttpError(error.message);
    });
  }, [currentPage, booksPerPage, bookDelete]);

  const indexOfLastBook: number = currentPage * booksPerPage;
  const indexOfFirstBook: number = indexOfLastBook - booksPerPage + 1;

  let lastItem: number =
    booksPerPage * currentPage <= totalAmountOfBooks
      ? booksPerPage * currentPage
      : totalAmountOfBooks;

  const paginate = (pageNumber: number) => setCurrentPage(pageNumber);

  const deleteBook = () => setBookDelete(!bookDelete);

  if (isLoading) {
    return <SpinnerLoading />;
  }

  if (httpError) {
    return (
      <div className='container m-5'>
        <p>{httpError}</p>
      </div>
    );
  }

  return (
    <div className='container mt-5'>
      {totalAmountOfBooks > 0 ? (
        <>
          <div className='mt-3'>
            <h3>Number of results: ({totalAmountOfBooks})</h3>
          </div>
          <p>
            {indexOfFirstBook + 1} to {lastItem} of {totalAmountOfBooks} items:
          </p>
          {books.map((book) => (
            <ChangeQuantityOfBook
              book={book}
              deleteBook={deleteBook}
              key={book.id}
            />
          ))}
        </>
      ) : (
        <h5>Add a book before changing quantity</h5>
      )}
      {totalAmountOfBooks > 1 && (
        <Pagination
          currentPage={currentPage}
          totalPages={totalPages}
          paginate={paginate}
        />
      )}
    </div>
  );
};

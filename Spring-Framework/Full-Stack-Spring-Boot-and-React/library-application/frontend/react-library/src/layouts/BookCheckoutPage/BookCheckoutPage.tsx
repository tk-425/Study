import { useEffect, useState } from 'react';
import BookModel from '../../models/BookModel';
import { SpinnerLoading } from '../Utils/SpinnerLoading';
import { StarsReview } from '../Utils/StarsReview';
import { CheckoutAndReviewBox } from './CheckoutAndReviewBox';
import ReviewModel from '../../models/ReviewModel';
import { LatestReviews } from './LatestReviews';
import { useOktaAuth } from '@okta/okta-react';

export const BookCheckoutPage = () => {
  const { authState } = useOktaAuth();

  const apiUrl: string = 'http://localhost:8080/api';

  // Book State
  const [book, setBook] = useState<BookModel>();
  const [isLoading, setIsLoading] = useState(true);

  // Review State
  const [reviews, setReviews] = useState<ReviewModel[]>([]);
  const [totalStars, setTotalStars] = useState(0);
  const [isLoadingReview, setIsLoadingReview] = useState(true);

  // Loans Count State
  const [currentLoansCount, setCurrentLoansCount] = useState(0);
  const [isLoadingCurrentLoansCount, setIsLoadingCurrentLoansCount] =
    useState(true);

  // HTTP Error State
  const [httpError, setHttpError] = useState(null);

  const urlBookIdValue = window.location.pathname.split('/')[2];

  // Fetch Books
  useEffect(() => {
    const fetchBook = async () => {
      const baseUrl: string = `${apiUrl}/books/${urlBookIdValue}`;

      const response = await fetch(baseUrl);

      if (!response.ok) {
        throw new Error('Something went wrong!');
      }

      const responseJson = await response.json();

      const loadedBooks: BookModel = {
        id: responseJson.id,
        title: responseJson.title,
        author: responseJson.author,
        description: responseJson.description,
        copies: responseJson.copies,
        copiesAvailable: responseJson.copiesAvailable,
        category: responseJson.category,
        img: responseJson.img,
      };

      setBook(loadedBooks);
      setIsLoading(false);
    };

    fetchBook().catch((error: any) => {
      setIsLoading(false);
      setHttpError(error.message);
    });
  }, [urlBookIdValue]);

  /// Fetch Reviews
  useEffect(() => {
    const fetchBookReviews = async () => {
      const reviewUrl: string = `${apiUrl}/reviews/search/findByBookId?bookId=${urlBookIdValue}`;

      const responseReviews = await fetch(reviewUrl);
      const responseJsonReviews = await responseReviews.json();
      const responseData = responseJsonReviews._embedded.reviews;

      const loadedReviews: ReviewModel[] = [];

      let weightedStarReviews: number = 0;

      for (const key in responseData) {
        loadedReviews.push({
          id: responseData[key].id,
          userEmail: responseData[key].userEmail,
          date: responseData[key].date,
          rating: responseData[key].rating,
          bookId: responseData[key].bookId,
          reviewDescription: responseData[key].reviewDescription,
        });
        weightedStarReviews = weightedStarReviews + responseData[key].rating;
      }

      if (loadedReviews) {
        const round = (
          Math.round((weightedStarReviews / loadedReviews.length) * 2) / 2
        ).toFixed(1);
        setTotalStars(Number(round));
      }

      setReviews(loadedReviews);
      setIsLoadingReview(false);
    };

    fetchBookReviews().catch((error: any) => {
      setIsLoadingReview(false);
      setHttpError(error.message);
    });
  }, [urlBookIdValue]);

  // Loan Count
  useEffect(() => {
    const fetchUserCurrentLoansCount = async () => {
      if (authState && authState.isAuthenticated) {
        const url = `http://localhost:8080/api/books/secure/currentloans/count`;
        const requestOptions = {
          method: 'GET',
          headers: {
            Authorization: `Bearer ${authState.accessToken?.accessToken}`,
            'Content-Type': 'application/json',
          },
        };
        const currentLoansCountResponse = await fetch(url, requestOptions);

        if (!currentLoansCountResponse.ok) {
          throw new Error('Something went wrong!');
        }

        const currentLoansCountResponseJson = await currentLoansCountResponse.json();
        setCurrentLoansCount(currentLoansCountResponseJson);
      }

      setIsLoadingCurrentLoansCount(false);
    };

    fetchUserCurrentLoansCount().catch((error: any) => {
      setIsLoadingCurrentLoansCount(false);
      setHttpError(error.message);
    });
  }, [authState]);

  if (isLoading || isLoadingReview || isLoadingCurrentLoansCount) {
    return <SpinnerLoading />;
  }

  if (httpError) {
    return (
      <div className='container mt-5'>
        <p>{httpError}</p>
      </div>
    );
  }

  return (
    <div>
      {/* Desktop */}
      <div className='container d-none d-lg-block'>
        <div className='row mt-5'>
          <div className='col-sm-2 col-md-2'>
            {book?.img ? (
              <img
                src={book?.img}
                width={226}
                height={349}
                alt='Book'
              />
            ) : (
              <img
                src={require('./../../Images/BooksImages/book-luv2code-1000.png')}
                width={226}
                height={349}
                alt='Book'
              />
            )}
          </div>

          <div className='col-4 col-md-4 container'>
            <div className='ml-2'>
              <h2>{book?.title}</h2>
              <h5 className='text-primary'>{book?.author}</h5>
              <p className='lead'>{book?.description}</p>
              <StarsReview
                rating={totalStars}
                size={32}
              />
            </div>
          </div>
          <CheckoutAndReviewBox
            book={book}
            mobile={false}
            currentLoansCount={currentLoansCount}
          />
        </div>
        <hr />
        <LatestReviews
          reviews={reviews}
          bookId={book?.id}
          mobile={false}
        />
      </div>

      {/* Mobile */}
      <div className='container d-lg-none mt-5'>
        <div className='d-flex justify-content-center align-items-center'>
          {book?.img ? (
            <img
              src={book?.img}
              width={226}
              height={349}
              alt='Book'
            />
          ) : (
            <img
              src={require('./../../Images/BooksImages/book-luv2code-1000.png')}
              width={226}
              height={349}
              alt='Book'
            />
          )}
        </div>
        <div className='mt-4'>
          <div className='ml-2'>
            <h2>{book?.title}</h2>
            <h5 className='text-primary'>{book?.author}</h5>
            <p className='lead'>{book?.description}</p>
            <StarsReview
              rating={totalStars}
              size={24}
            />
          </div>
        </div>
        <CheckoutAndReviewBox
          book={book}
          mobile={true}
          currentLoansCount={currentLoansCount}
        />
        <hr />
        <LatestReviews
          reviews={reviews}
          bookId={book?.id}
          mobile={true}
        />
      </div>
    </div>
  );
};

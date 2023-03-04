import React from 'react';
import { Link } from 'react-router-dom';
import BookModel from '../../models/BookModel';

type Props = {
  book: BookModel | undefined;
  mobile: boolean;
  currentLoansCount: number;
};

export const CheckoutAndReviewBox = (props: Props) => {
  return (
    <div
      className={
        props.mobile ? 'card d-flex mt-5' : 'card col-4 container d-flex mb-5'
      }
    >
      <div className='card-body container'>
        <div className='mt-3'>
          <p>
            <b>{props.currentLoansCount}/5</b> books checked out
          </p>
          <hr />
          {props.book &&
          props.book.copiesAvailable &&
          props.book.copiesAvailable > 0 ? (
            <h4 className='text-success'>Available</h4>
          ) : (
            <h4 className='text-danger'>Wait List</h4>
          )}
          <div className='row'>
            <p className='col-6 lead'>
              <b>{props.book?.copies}</b> copies
            </p>
            <p className='col-6 lead'>
              <b>{props.book?.copiesAvailable}</b> available
            </p>
          </div>
        </div>
        <Link
          className='btn btn-success btn-lg'
          to='/#'
        >
          Sign in
        </Link>
        <hr />
        <p className='mt-3'>
          This number can change until placing order has been complete.
        </p>
        <p>Sign in to be able to leave a review.</p>
      </div>
    </div>
  );
};

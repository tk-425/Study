import { useState } from 'react';
import { StarsReview } from './StarsReview';

type Props = {
  submitReview: any;
};

export const LeaveAReview = (props: Props) => {
  const [starInput, setStarInput] = useState(0);
  const [displayInput, setDisplayInput] = useState(false);
  const [reviewDescription, setReviewDescription] = useState('');

  function starValue(value: number) {
    setStarInput(value);
    setDisplayInput(true);
  }

  return (
    <div
      className='dropdown'
      style={{ cursor: 'pointer' }}
    >
      <h5
        className='dropdown-toggle'
        id='dropdownMenuButton1'
        data-bs-toggle='dropdown'
      >
        Leave a review?
      </h5>
      <ul
        className='dropdown-menu'
        id='submitReviewRating'
        aria-labelledby='dropdownMenuButton1'
      >
        <li>
          <button
            className='dropdown-item'
            onClick={() => starValue(0)}
          >
            0 start
          </button>
        </li>
        <li>
          <button
            className='dropdown-item'
            onClick={() => starValue(0.5)}
          >
            .5 start
          </button>
        </li>
        <li>
          <button
            className='dropdown-item'
            onClick={() => starValue(1)}
          >
            1 start
          </button>
        </li>
        <li>
          <button
            className='dropdown-item'
            onClick={() => starValue(1.5)}
          >
            1.5 start
          </button>
        </li>
        <li>
          <button
            className='dropdown-item'
            onClick={() => starValue(2)}
          >
            2 start
          </button>
        </li>
        <li>
          <button
            className='dropdown-item'
            onClick={() => starValue(2.5)}
          >
            2.5 start
          </button>
        </li>
        <li>
          <button
            className='dropdown-item'
            onClick={() => starValue(3)}
          >
            3 start
          </button>
        </li>
        <li>
          <button
            className='dropdown-item'
            onClick={() => starValue(3.5)}
          >
            3.5 start
          </button>
        </li>
        <li>
          <button
            className='dropdown-item'
            onClick={() => starValue(4)}
          >
            4 start
          </button>
        </li>
        <li>
          <button
            className='dropdown-item'
            onClick={() => starValue(4.5)}
          >
            4.5 start
          </button>
        </li>
        <li>
          <button
            className='dropdown-item'
            onClick={() => starValue(5)}
          >
            5 start
          </button>
        </li>
      </ul>
      <StarsReview
        rating={starInput}
        size={32}
      />
      {displayInput && (
        <form
          method='POST'
          action='/#'
        >
          <hr />

          <div className='mb-3'>
            <label
              htmlFor=''
              className='form-label'
            >
              Description
            </label>
            <textarea
              className='form-control'
              id='submitReviewDescription'
              rows={3}
              placeholder='Leave a review'
              onChange={(e) => setReviewDescription(e.target.value)}
            />
          </div>

          <div>
            <button
              className='btn btn-primary mt-3'
              type='button'
              onClick={() => props.submitReview(starInput, reviewDescription)}
            >
              Submit Review
            </button>
          </div>
        </form>
      )}
    </div>
  );
};

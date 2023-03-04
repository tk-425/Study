import React from 'react';
import { StarFull } from './StarFull';
import { StarHalf } from './StarHalf';
import { StarEmpty } from './StarEmpty';

type Props = {
  rating: number;
  size: number;
};

export const StarsReview = (props: Props) => {
  let rating = props.rating;
  let fullStars = 0;
  let halfStars = 0;
  let emptyStars = 0;

  if (rating !== undefined && rating > 0 && rating <= 5) {
    for (let i = 0; i < 5; i++) {
      if (rating > 0.5) {
        fullStars += 1;
        rating -= 1;
      } else if (rating === 0.5) {
        halfStars += 1;
        rating -= 0.5;
      } else if (rating === 0) {
        emptyStars += 1;
      } else {
        break;
      }
    }
  } else {
    emptyStars = 5;
  }

  return (
    <div>
      {Array.from({ length: fullStars }, (_, i) => (
        <StarFull
          key={i}
          size={props.size}
        />
      ))}

      {Array.from({ length: halfStars }, (_, i) => (
        <StarHalf
          key={i}
          size={props.size}
        />
      ))}

      {Array.from({ length: emptyStars }, (_, i) => (
        <StarEmpty
          key={i}
          size={props.size}
        />
      ))}
    </div>
  );
};

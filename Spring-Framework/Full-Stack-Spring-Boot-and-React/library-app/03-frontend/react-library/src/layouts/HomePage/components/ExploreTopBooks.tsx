import React from "react";

export const ExploreTopBook = () => {
  return (
    <div className="p-5 mb-4 bg-dark header">
      <div className="container-fluid py-5 text-white d-flex justify-content-center align-items-center">
        <div className="display-5 fw-bold">
          Find your next adventure
          <p className="col-md-8 fs-4">
            Where would you like to go next?
          </p>
          <a className="btn main-color btn-lg text-white" href="/#" type="button">Explore top books</a>
        </div>
      </div>
    </div>
  );
}
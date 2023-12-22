import React from "react";
import Image from 'next/image'

export default function ViewDetail({ title, image, price, id,description }) {
  return (
    <>
    <div className="d-flex , justify-center">
            <div class="col-md-6 ">
        <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
          <div class="col p-4 d-flex flex-column position-static">
            <strong class="d-inline-block mb-2 text-success">TOP: {id}</strong>
            <h3 class="mb-0">{title}</h3>
            <div class="mb-1 text-muted">{price}$</div>
            <p class="mb-auto">
              {description}
            </p>
            <a href="#" class="stretched-link">
              Continue reading
            </a>
          </div>
          <div class="col-auto d-none d-lg-block">
            <img
              src={image}
              class="bd-placeholder-img"
              width="200"
              height="250"
              xmlns="http://www.w3.org/2000/svg"
              role="img"
              aria-label="Placeholder: Thumbnail"
              preserveAspectRatio="xMidYMid slice"
              focusable="false"
            />
              <title>Placeholder</title>
              <rect width="100%" height="100%" fill="#55595c"></rect>
              <text x="50%" y="50%" fill="#eceeef" dy=".3em">
              </text>
          </div>
        </div>
      </div>
    </div>

    </>
  );
}

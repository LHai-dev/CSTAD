"use client";
import React from "react";
import ViewDetail from "./ViewDetail";
import { useRouter } from "next/navigation";
import Link from "next/link";
import Image from 'next/image'

export default function CardCompponent({ title, image, price, id,description }) {
  const router=useRouter();

  console.log("description", description)

  return (
    <>
      <div className="col-sm-6 col-md-6 col-lg-4 mt-5" >
        <div className="card">
          <div className="card-body ">
            <img
              className="p-8 rounded-t-lg"
              src={image ? image : "/images/placeholder-image.png"}
              alt="product image"
            />

            <h5 className="card-title">{title ? title : "Untitled"} </h5>

            <p className="card-text">
              {description ? description:"we dont have"}
             
            </p>
              <div style={{display:'flex'}}>
              <Link href={`/viewDetail/${id}`} className="btn btn-primary card-link">
                View Details
              </Link>
           
              </div>
          </div>

          <div className="card-footer"> <h3 style={{textAlign:'center'}}>${price}</h3></div>
        </div>
      </div>
    </>
  );
}

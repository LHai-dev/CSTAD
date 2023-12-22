import React, { useEffect, useState } from "react"
import ProductCard from "./ProductCard"
import 'bootstrap/dist/css/bootstrap.min.css';


export default function Product1() {
    const [product, setProduct] = useState([{}])
  useEffect(()=>{
    fetch("https://api.escuelajs.co/api/v1/products")
    .then((res)=> res.json())
    .then((data)=> {
      setProduct(data)
    
    })
  })
  return (
    
      		<div className=" container " >
          <div className="row">
          {
            product.map((p, index) => (
              <ProductCard
              product={p}
              key={index}
              />
            ))
          }
          </div>
      </div>

  )
}

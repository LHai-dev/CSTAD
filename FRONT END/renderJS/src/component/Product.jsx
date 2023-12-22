import React, { useEffect, useState } from "react"
import ProductCard from './ProductCard'
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

export default function Products() {
	const [product, setProduct] = useState([{}])
  useEffect(()=>{
    fetch("https://api.escuelajs.co/api/v1/products")
    .then((res)=> res.json())
    .then((data)=> {
      setProduct(data)
    
    })
  })

	return (
		<div className='container' style={{boxSizing:"border-box"}}>
			<h1 className=' ' style={{textAlign:"center" , backgroundColor:"gray" , width:"100%",height:"10vh"}}>
				{" "}
				
				<span className='' >Limhai</span> 
				
			</h1>


		<div className="card2" style={{margin:"0 auto"}}>
				{product.map((p, index) => (
					<ProductCard
            
						product={p}
						key={index}
					/>
				))}
			</div>
		</div>
	)
}


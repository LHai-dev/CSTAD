import React from 'react'
import Bt from "./Bt"
import moment from 'moment/moment'
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
const ProductCard =({product}) =>{
  return (
        <div className='card1'>
    <Card className='card4' style={{ width: '18rem' }}>
      <Card.Img variant="top" src={product.images}
				alt='product_image' />
      <Card.Body>
        <Card.Title>{product.title}</Card.Title>
        <Card.Text>
        {product.description}
          ${product.price}
          <h4>{moment(product.creationAt).format('DD/MM/YYYY HH:mm') }</h4>
        </Card.Text>
        <Bt
					title={"Buy now"}
					btnStyle={""}
				/>
               
                <Bt 
					title={"add to card"}
					btnStyle={""}
				/>
                
				
      </Card.Body>
    </Card>
        </div>
        
  )
}
export default ProductCard

import React, { useState, useEffect } from 'react';
import { Card, Button, Placeholder } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

export default function ProductCard({ product }) {
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    // Simulate API call
    setTimeout(() => {
      setIsLoading(false);
    }, 3000);
  }, []);

  return (
    <div className="col-3 mt-3">
      {isLoading ? (
        <Card style={{ width: '18rem' }}>
        <Card.Img variant="top" src="https://www.itechinsiders.com/wp-content/uploads/2019/01/1_okufk5mMDbTfqA5iS_rldQ.png" />
        <Card.Body>
          <Placeholder as={Card.Title} animation="glow">
            <Placeholder xs={6} />
          </Placeholder>
          <Placeholder as={Card.Text} animation="glow">
            <Placeholder xs={7} /> <Placeholder xs={4} /> <Placeholder xs={4} />{' '}
            <Placeholder xs={6} /> <Placeholder xs={8} />
          </Placeholder>
          <Placeholder.Button variant="primary" xs={6} />
        </Card.Body>
      </Card>
      ) : (
        <Card style={{ width: '18rem' }}>
          <Card.Img variant="top" src={product.images} />
          <Card.Body>
            <Card.Title>{product.title}</Card.Title>
            <Card.Text>
              {product.description}
              ${product.price}
              Some quick example text to build on the card title and make up the
              bulk of the card's content.
            </Card.Text>
            <Button variant="primary">Go somewhere</Button>
          </Card.Body>
        </Card>
      )}

    </div>
  );
}

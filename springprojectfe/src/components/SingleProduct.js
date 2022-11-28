import React from 'react'
import { Button } from 'react-bootstrap';

export default function SingleProduct(props) {
  const { product } = props;
  return (
    <div>
      <ul>
        <div key={product.id}>
          <div>
            <img src={product.picture_p}></img>
          </div>
          <h2>Name: {product.productName_p}</h2>
          <p>Description: {product.description_d}</p>
          <p>Price: {product.price_p} $</p>
          <p>Status: {product.status_s}</p>
        </div>
        <div>
          <Button onClick={() => {window.location.href = 'http://localhost:3000/'}}>Back</Button>
        </div>
      </ul>
    </div>
  )
}
